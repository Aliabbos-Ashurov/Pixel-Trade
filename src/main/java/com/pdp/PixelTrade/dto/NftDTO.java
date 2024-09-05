package com.pdp.PixelTrade.dto;

import com.pdp.PixelTrade.enums.Category;
import com.pdp.PixelTrade.enums.CryptoType;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024
 **/
public record NftDTO(
        Long id,
        String name,
        String description,
        String imageUrl,
        String tokenId,
        Double price,
        boolean onAuction,
        LocalDateTime auctionStartDate,
        Double auctionStartingPrice,
        LocalDateTime auctionEndDate,
        Integer likesCount,
        Integer viewsCount,
        Long ownerId,
        Long collectionId,
        Long metadataId,
        Category category,
        CryptoType cryptoType
) implements DTO {
}
