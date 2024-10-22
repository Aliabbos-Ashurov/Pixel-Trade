package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.request.TransactionRequestDTO;
import com.pdp.PixelTrade.dto.transaction.response.TransactionResponseDTO;
import com.pdp.PixelTrade.entity.wallet.*;
import com.pdp.PixelTrade.enums.TransactionStatus;
import com.pdp.PixelTrade.exceptions.crypto.CryptoOperationException;
import com.pdp.PixelTrade.exceptions.transaction.CryptoTransactionException;
import com.pdp.PixelTrade.exceptions.transaction.InsufficientBalanceException;
import com.pdp.PixelTrade.exceptions.transaction.WalletSuspicionRecordException;
import com.pdp.PixelTrade.mapper.TransactionMapper;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:48
 **/
@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final TransactionService transactionService;
    private final FeeService feeService;
    private final P2PMarketService p2PMarketService;
    private final CryptoService cryptoService;
    private final CryptoAssetService cryptoAssetService;
    private final WalletService walletService;
    private final WalletHistoryService walletHistoryService;
    private final WalletSuspicionRecordService walletSuspicionRecordService;
    private final TransactionMapper transactionMapper;

    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final BigDecimal ONE = BigDecimal.ONE;

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            timeout = 3
    )
    public Response<TransactionResponseDTO> transferW2W(@NotNull TransactionRequestDTO request) {
        Wallet fromWallet = fetchAndValidateWallet(request.fromAddress());
        Wallet toWallet = fetchAndValidateWallet(request.toAddress());

        BigDecimal feePercentage = cryptoService.getFeePercentage(request.cryptoType())
                .orElseThrow(() -> new CryptoOperationException("Crypto not found with symbol: {0}", request.cryptoType()));
        CryptoAsset fromCryptoAsset = cryptoAssetService.find(request.fromAddress(), request.cryptoType())
                .orElseThrow(() -> new CryptoTransactionException("Crypto Asset not found with symbol: {0} on wallet address: {1}", request.cryptoType(), request.fromAddress()));

        BigDecimal totalAmount = calculateTotalWithFee(request.amount(), feePercentage);
        validateSufficientFunds(fromCryptoAsset, totalAmount);

        fromCryptoAsset.setAmount(fromCryptoAsset.getAmount().subtract(totalAmount));
        cryptoAssetService.update(fromCryptoAsset);

        CryptoAsset toCryptoAsset = cryptoAssetService.find(request.toAddress(), request.cryptoType())
                .orElseGet(() -> cryptoAssetService.createCryptoAsset(request.toAddress(), BigDecimal.ZERO, request.cryptoType()));
        toCryptoAsset.setAmount(toCryptoAsset.getAmount().add(request.amount()));
        cryptoAssetService.update(toCryptoAsset);

        BigDecimal feeAmount = calculateFeeAmount(request.amount(), feePercentage);
        Fee fee = createTransactionAndFee(request, fromWallet, toWallet, feeAmount, feePercentage);

        return buildResponse(request, fee);
    }

    private Wallet fetchAndValidateWallet(@NotNull String address) {
        Wallet wallet = walletService.findByAddress(address);
        checkWalletSuspicion(address);
        return wallet;
    }

    private BigDecimal calculateTotalWithFee(@NotNull BigDecimal amount, @NotNull BigDecimal feePercentage) {
        if (feePercentage.signum() == 0)
            return amount;
        BigDecimal multiplier = ONE.add(feePercentage.divide(HUNDRED));
        return amount.multiply(multiplier);
    }

    private BigDecimal calculateFeeAmount(@NotNull BigDecimal amount, @NotNull BigDecimal feePercentage) {
        if (feePercentage.signum() == 0)
            return BigDecimal.ZERO;
        return amount.multiply(feePercentage).divide(HUNDRED);
    }

    private Fee createTransactionAndFee(TransactionRequestDTO request, Wallet fromWallet, Wallet
            toWallet, BigDecimal earnedFee, BigDecimal feePercentage) {
        LocalDateTime now = LocalDateTime.now();

        Transaction transaction = Transaction.builder()
                .fromWallet(fromWallet)
                .toWallet(toWallet)
                .amount(request.amount())
                .cryptoType(request.cryptoType())
                .transactionStatus(TransactionStatus.PENDING)
                .transactionType(request.transactionType())
                .confirmedAt(now) // Set confirmed time
                .build();

        Fee fee = Fee.builder()
                .transaction(transaction)
                .fee(earnedFee)
                .feePercentage(feePercentage)
                .build();

        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        transaction.setFee(fee);

        transactionService.saveTransaction(transaction);

        walletHistoryService.save(WalletHistory.builder()
                .amount(request.amount())
                .transactionType(transaction.getTransactionType())
                .transaction(transaction)
                .wallet(fromWallet)
                .createdAt(now)
                .build());

        return fee;
    }

    private void checkWalletSuspicion(String address) {
        if (walletSuspicionRecordService.exists(address)) {
            throw new WalletSuspicionRecordException("Wallet suspicion record exists on address: {0}", address);
        }
    }

    private void validateSufficientFunds(CryptoAsset cryptoAsset, BigDecimal total) {
        if (cryptoAsset.getAmount().compareTo(total) < 0) {
            throw new InsufficientBalanceException("Insufficient funds for crypto asset: {0} {1} {2}",
                    cryptoAsset.getCryptoType(), cryptoAsset.getAmount(), total);
        }
    }

    private Response<TransactionResponseDTO> buildResponse(TransactionRequestDTO request, Fee fee) {
        Transaction transactionSaved = fee.getTransaction();
        TransactionResponseDTO response = transactionMapper.transactionResponseDTO(request, fee);
        response.setId(transactionSaved.getId());
        response.setTransactionStatus(TransactionStatus.COMPLETED);
        response.setConfirmedAt(transactionSaved.getConfirmedAt());
        return Response.ok(response);
    }
}
