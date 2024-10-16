package com.pdp.PixelTrade.entity.nft;

import jakarta.persistence.Column;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author Doniyor Nishonov
 * @since 10/October/2024  10:12
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class CollectionStatistics {

    @Builder.Default
    @PositiveOrZero
    @Column(name = "nft_count", nullable = false)
    private Integer nftCount = 0;

    @Builder.Default
    @PositiveOrZero
    @Column(name = "total_likes", nullable = false)
    private Integer totalLikes = 0;

    @Builder.Default
    @PositiveOrZero
    @Column(name = "total_views", nullable = false)
    private Integer totalViews = 0;
}
