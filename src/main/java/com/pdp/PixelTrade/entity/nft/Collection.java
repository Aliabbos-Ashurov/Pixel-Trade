package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  12:54
 **/
@Entity
@Table(name = "collection")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Collection extends Auditable {

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "banner_image_url")
    private String bannerImageUrl;

    @Column(name = "banner_gif_url")
    private String bannerGifUrl;

    @Builder.Default
    @Column(name = "is_verified")
    private boolean isVerified = false;

    @Builder.Default
    @Column(name = "is_premium")
    private boolean isPremium = false;

    @PositiveOrZero
    @Column(name = "nft_count")
    private Integer nftCount;

    @PositiveOrZero
    @Column(name = "total_likes")
    private Integer totalLikes;

    @PositiveOrZero
    @Column(name = "total_views")
    private Integer totalViews;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NFT> nfts;

    @OneToMany(mappedBy = "collection")
    private Set<ConnectedApp> connectedApps;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CryptoType cryptoType; // ETH, BITCOIN
}