package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:01
 **/
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByBuyerId(Long buyerId);

    List<Transaction> findByNftId(Long nftId);
}
