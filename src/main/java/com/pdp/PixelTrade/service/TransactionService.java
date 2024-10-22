package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
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

    public Response<List<Transaction>> findTransactionsBetweenWallets(
            @NotNull String fromWalletAddress,
            @NotNull String toWalletAddress) {
        return Response.ok(transactionRepository.findTransactionsBetweenWallets(fromWalletAddress, toWalletAddress));
    }

    public void saveTransaction(@NotNull Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public long countTransactionsByAddress(@NotNull String address) {
        return transactionRepository.countTransactionsByAddress(address);
    }

    public Response<List<Transaction>> findTransactionsBetweenDates(
            @NotNull LocalDateTime startDate,
            @NotNull LocalDateTime endDate) {
        return Response.ok(transactionRepository.findTransactionsBetweenDates(startDate, endDate));
    }

    public Response<List<Transaction>> findByTransactionStatus(@NotNull TransactionStatus status) {
        return Response.ok(transactionRepository.findByTransactionStatus(status));
    }

    public Response<List<Transaction>> findAllByAddress(@NotNull String address) {
        return Response.ok(transactionRepository.findAllByAddress(address));
    }

    public Response<List<Transaction>> findByTransactionType(@NotNull TransactionType type) {
        return Response.ok(transactionRepository.findByTransactionType(type));
    }

    public Response<List<Transaction>> findPendingTransactions() {
        return Response.ok(transactionRepository.findPendingTransactions());
    }

    public Response<List<Transaction>> findFailedTransactions() {
        return Response.ok(transactionRepository.findFailedTransactions());
    }

    public Response<List<Transaction>> findTransactionsWithQRCode() {
        return Response.ok(transactionRepository.findTransactionsWithQRCode());
    }

    public Response<List<Transaction>> findByTransactionStatuses(@NotNull List<TransactionStatus> statuses) {
        return Response.ok(transactionRepository.findByTransactionStatuses(statuses));
    }
}
