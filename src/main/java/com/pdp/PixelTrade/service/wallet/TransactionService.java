package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.Transaction;
import com.pdp.PixelTrade.enums.TransactionStatus;
import com.pdp.PixelTrade.enums.TransactionType;
import com.pdp.PixelTrade.repository.wallet.TransactionRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  12:22
 **/
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public ApiResponse<List<Transaction>> findTransactionsBetweenWallets(
            @NotNull String fromWalletAddress,
            @NotNull String toWalletAddress) {
        return ApiResponse.ok(transactionRepository.findTransactionsBetweenWallets(fromWalletAddress, toWalletAddress));
    }

    public void saveTransaction(@NotNull Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public long countTransactionsByAddress(@NotNull String address) {
        return transactionRepository.countTransactionsByAddress(address);
    }

    public ApiResponse<List<Transaction>> findTransactionsBetweenDates(
            @NotNull LocalDateTime startDate,
            @NotNull LocalDateTime endDate) {
        return ApiResponse.ok(transactionRepository.findTransactionsBetweenDates(startDate, endDate));
    }

    public ApiResponse<List<Transaction>> findByTransactionStatus(@NotNull TransactionStatus status) {
        return ApiResponse.ok(transactionRepository.findByTransactionStatus(status));
    }

    public ApiResponse<List<Transaction>> findAllByAddress(@NotNull String address) {
        return ApiResponse.ok(transactionRepository.findAllByAddress(address));
    }

    public ApiResponse<List<Transaction>> findByTransactionType(@NotNull TransactionType type) {
        return ApiResponse.ok(transactionRepository.findByTransactionType(type));
    }

    public ApiResponse<List<Transaction>> findPendingTransactions() {
        return ApiResponse.ok(transactionRepository.findPendingTransactions());
    }

    public ApiResponse<List<Transaction>> findFailedTransactions() {
        return ApiResponse.ok(transactionRepository.findFailedTransactions());
    }

    public ApiResponse<List<Transaction>> findTransactionsWithQRCode() {
        return ApiResponse.ok(transactionRepository.findTransactionsWithQRCode());
    }

    public ApiResponse<List<Transaction>> findByTransactionStatuses(@NotNull List<TransactionStatus> statuses) {
        return ApiResponse.ok(transactionRepository.findByTransactionStatuses(statuses));
    }
}
