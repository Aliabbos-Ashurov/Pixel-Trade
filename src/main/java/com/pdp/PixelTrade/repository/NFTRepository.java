package com.pdp.PixelTrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:00
 **/
public interface NFTRepository extends JpaRepository<NFT, Long> {

    List<NFT> findByCollectionId(Long collectionId);

    List<NFT> findByOnAuctionTrue();

    List<NFT> findByNameContainingIgnoreCase(String name);
}
