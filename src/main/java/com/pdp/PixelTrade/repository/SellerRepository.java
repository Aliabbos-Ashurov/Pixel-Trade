package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.wallet.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {


    @Query("""
            FROM Seller s
            WHERE s.deleted = FALSE
            """)
    List<Seller> findAllSellers();

    @Query("""
            FROM Seller s
            WHERE s.name = :name
            AND s.deleted = FALSE
            """)
    Seller findByName(@Param("name") String name);

    @Query("""
            FROM Seller s
            WHERE s.user.id = :sellerId
            AND s.deleted = FALSE
            """)
    Optional<Seller> findBySellerId(@Param("sellerId") Long sellerId);
}