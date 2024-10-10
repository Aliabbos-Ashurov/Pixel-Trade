package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Collection extends Auditable {

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "banner_image_url")
    private String bannerImageUrl;

    @Column(name = "banner_gif_url")
    private String bannerGifUrl;

    @Builder.Default
    @Column(name = "is_verified", nullable = false)
    private boolean isVerified = false;

    @Builder.Default
    @Column(name = "is_premium", nullable = false)
    private boolean isPremium = false;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NFT> nfts;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ConnectedApp> connectedApps;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Crypto type is required")
    @Column(nullable = false)
    private CryptoType cryptoType;

    @Embedded
    private CollectionStatistics statistics;
}
