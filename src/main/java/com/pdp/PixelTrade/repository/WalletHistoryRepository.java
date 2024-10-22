package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.dto.transaction.response.WalletHistoryResponseDTO;
import com.pdp.PixelTrade.entity.wallet.WalletHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WalletHistoryRepository extends JpaRepository<WalletHistory, Long> {

    @Query("""
             SELECT new com.pdp.PixelTrade.dto.transaction.response.WalletHistoryResponseDTO(
                    wh.amount, t.cryptoType, wh.transactionType, t.confirmedAt, wh.description)
                FROM WalletHistory wh
                LEFT JOIN Transaction t ON wh.transaction.id = t.id
                AND wh.deleted = FALSE
                AND t.deleted = FALSE
            """)
    List<WalletHistoryResponseDTO> findAllDtos();

    @Query("""
             SELECT new com.pdp.PixelTrade.dto.transaction.response.WalletHistoryResponseDTO(
                    wh.amount, t.cryptoType, wh.transactionType, t.confirmedAt, wh.description)
                FROM WalletHistory wh
                LEFT JOIN Transaction t ON wh.transaction.id = t.id
                WHERE wh.wallet.id = :walletId
                AND wh.deleted = FALSE
                AND t.deleted = FALSE
            """)
    List<WalletHistoryResponseDTO> findByWalletId(@Param("walletId") Long walletId);


    @Query("""
            SELECT new com.pdp.PixelTrade.dto.transaction.response.WalletHistoryResponseDTO(
                    wh.amount, t.cryptoType, wh.transactionType, t.confirmedAt, wh.description)
                FROM WalletHistory wh
                LEFT JOIN Transaction t ON wh.transaction.id = t.id
                WHERE wh.wallet.address = :address
                AND wh.deleted = FALSE
                AND t.deleted = FALSE
            """)
    List<WalletHistoryResponseDTO> findByWalletAddress(@Param("address") String address);
}