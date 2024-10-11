package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.wallet.Transaction;
import com.pdp.PixelTrade.enums.TransactionStatus;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  12:21
 **/
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(""" 
            FROM Transaction t WHERE t.fromWallet.address = :fromWalletAddress
            AND t.toWallet.address = :toWalletAddress
            AND t.deleted = FALSE
            """)
    List<Transaction> findTransactionsBetweenWallets(
            @NotNull @Param("fromWalletAddress") String fromWalletAddress,
            @NotNull @Param("toWalletAddress") String toWalletAddress);

    @Query(""" 
            SELECT COUNT(t) FROM Transaction t
            WHERE t.fromWallet.address = :address
            AND t.deleted = FALSE
            """)
    long countTransactionsByAddress(@NotNull @Param("address") String address);

    @Query("""
            SELECT t FROM Transaction t
            WHERE t.confirmedAt BETWEEN :startDate AND :endDate
            """)
    List<Transaction> findTransactionsBetweenDates(
            @NotNull @Param("startDate") LocalDateTime startDate,
            @NotNull @Param("endDate") LocalDateTime endDate
    );

    @Query("""
            SELECT t FROM Transaction t
            WHERE t.transactionStatus = :status
            AND t.deleted = FALSE
            """)
    List<Transaction> findByTransactionStatus(@Param("status") TransactionStatus status);

    @Query("""
            FROM Transaction t
            WHERE t.fromWallet.address = :address
            AND t.deleted = FALSE
            """)
    List<Transaction> findAllByAddress(@NotNull @Param("address") String address);

    @Query("""
            FROM Transaction t
            WHERE t.transactionType = :type
            AND t.deleted = FALSE
            """)
    List<Transaction> findByTransactionType(@NotNull @Param("transactionType") TransactionType type);

    @Query("""
            FROM Transaction t WHERE t.transactionStatus = 'PENDING'
            AND t.deleted = FALSE
            """)
    List<Transaction> findPendingTransactions();

    @Query("""
            FROM Transaction t
            WHERE t.transactionStatus = 'FAILED'
            AND t.deleted = FALSE
            """)
    List<Transaction> findFailedTransactions();

    @Query("""
            SELECT t FROM Transaction t
            WHERE t.qrCode IS NOT NULL
            AND t.deleted = FALSE
            """)
    List<Transaction> findTransactionsWithQRCode();

    @Query("""
            SELECT t FROM Transaction t
            WHERE t.transactionStatus IN :statuses
            AND t.deleted = FALSE
            """)
    List<Transaction> findByTransactionStatuses(@Param("statuses") List<TransactionStatus> statuses);
}
