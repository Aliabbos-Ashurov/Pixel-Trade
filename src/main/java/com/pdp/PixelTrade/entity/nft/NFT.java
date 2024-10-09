package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.Category;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  12:47
 **/
@Entity
@Table(name = "nft")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class NFT extends Auditable {

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @NotBlank
    @Column(name = "token_id", unique = true, nullable = false, updatable = false)
    private String tokenId;

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 32, scale = 8)
    private BigDecimal price;

    @Builder.Default
    @Column(name = "on_auction", nullable = false)
    private boolean onAuction = false;

    @FutureOrPresent(message = "Auction start date must be in the present or future")
    @Column(name = "auction_start_date")
    private LocalDateTime auctionStartDate;


    @DecimalMin("0.0")
    @Column(name = "auction_starting_price", precision = 32, scale = 8)
    private BigDecimal auctionStartingPrice;

    @FutureOrPresent(message = "Auction end date must be in the present or future")
    @Column(name = "auction_end_date")
    private LocalDateTime auctionEndDate;

    @PositiveOrZero
    @Column(name = "likes_count", nullable = false)
    private Integer likesCount = 0;

    @PositiveOrZero
    @Column(name = "views_count", nullable = false)
    private Integer viewsCount = 0;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private CryptoType cryptoType;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Upload image;


    @OneToMany(mappedBy = "nft", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offer> offers;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = false, updatable = false)
    private Collection collection;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metadata_id", referencedColumnName = "id", nullable = false)
    private Metadata metadata;

}
