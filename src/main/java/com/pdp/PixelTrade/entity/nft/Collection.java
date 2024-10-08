package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.HashSet;
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
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @URL
    @Column(name = "banner_image_url")
    private String bannerImageUrl;

    @URL
    @Column(name = "banner_gif_url")
    private String bannerGifUrl;

    @Builder.Default
    @Column(name = "is_verified", nullable = false)
    private boolean isVerified = false;

    @Builder.Default
    @Column(name = "is_premium", nullable = false)
    private boolean isPremium = false;

    @PositiveOrZero
    @Column(name = "nft_count", nullable = false)
    private Integer nftCount = 0;

    @PositiveOrZero
    @Column(name = "total_likes", nullable = false)
    private Integer totalLikes = 0;

    @PositiveOrZero
    @Column(name = "total_views", nullable = false)
    private Integer totalViews = 0;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NFT> nfts = new ArrayList<>();

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ConnectedApp> connectedApps = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Crypto type is required")
    @Column(nullable = false)
    private CryptoType cryptoType;
}
