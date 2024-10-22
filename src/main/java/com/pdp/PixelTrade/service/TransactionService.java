package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.entity.wallet.Transaction;
import com.pdp.PixelTrade.enums.TransactionStatus;
import com.pdp.PixelTrade.enums.TransactionType;
import com.pdp.PixelTrade.mapper.TransactionMapper;
import com.pdp.PixelTrade.repository.wallet.TransactionRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  12:22
 **/
@Service
public class TransactionService extends AbstractService<TransactionRepository, TransactionMapper> {

    public TransactionService(TransactionRepository repository, TransactionMapper mapper) {
        super(repository, mapper);
    }

    public Response<List<Transaction>> findTransactionsBetweenWallets(
            @NotNull String fromWalletAddress,
            @NotNull String toWalletAddress) {
        return Response.ok(repository.findTransactionsBetweenWallets(fromWalletAddress, toWalletAddress));
    }

    public void saveTransaction(@NotNull Transaction transaction) {
        repository.save(transaction);
    }

    public long countTransactionsByAddress(@NotNull String address) {
        return repository.countTransactionsByAddress(address);
    }

    public Response<List<Transaction>> findTransactionsBetweenDates(
            @NotNull LocalDateTime startDate,
            @NotNull LocalDateTime endDate) {
        return Response.ok(repository.findTransactionsBetweenDates(startDate, endDate));
    }

    public Response<List<Transaction>> findByTransactionStatus(@NotNull TransactionStatus status) {
        return Response.ok(repository.findByTransactionStatus(status));
    }

    public Response<List<Transaction>> findAllByAddress(@NotNull String address) {
        return Response.ok(repository.findAllByAddress(address));
    }

    public Response<List<Transaction>> findByTransactionType(@NotNull TransactionType type) {
        return Response.ok(repository.findByTransactionType(type));
    }

    public Response<List<Transaction>> findPendingTransactions() {
        return Response.ok(repository.findPendingTransactions());
    }

    public Response<List<Transaction>> findFailedTransactions() {
        return Response.ok(repository.findFailedTransactions());
    }

    public Response<List<Transaction>> findTransactionsWithQRCode() {
        return Response.ok(repository.findTransactionsWithQRCode());
    }

    public Response<List<Transaction>> findByTransactionStatuses(@NotNull List<TransactionStatus> statuses) {
        return Response.ok(repository.findByTransactionStatuses(statuses));
    }
}
