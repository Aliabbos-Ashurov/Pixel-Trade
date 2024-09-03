package com.pdp.PixelTrade.entity;

import com.pdp.PixelTrade.enums.Category;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.MediaType;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Upload image;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MediaType mediaType;

    @Column(name = "token_id", unique = true)
    private String tokenId;

    @PositiveOrZero
    private Double price;

    @Builder.Default
    @Column(name = "on_auction")
    private boolean onAuction = false;

    @FutureOrPresent
    @Column(name = "auction_start_date")
    private LocalDateTime auctionStartDate;

    @PositiveOrZero
    @Column(name = "auction_starting_price")
    private Double auctionStartingPrice;

    @FutureOrPresent
    @Column(name = "auction_end_date")
    private LocalDateTime auctionEndDate;

    @PositiveOrZero
    @Column(name = "likes_count")
    private Integer likesCount;

    @PositiveOrZero
    @Column(name = "views_count")
    private Integer viewsCount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metadata_id", referencedColumnName = "id")
    private Metadata metadata;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CryptoType cryptoType;

    @OneToMany(mappedBy = "nft", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offer> offers;
}
