package com.pdp.PixelTrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:00
 **/
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findByNftId(Long nftId);

    List<Offer> findByBidderId(Long bidderId);
}
