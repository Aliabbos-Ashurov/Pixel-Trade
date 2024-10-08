package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.Category;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String name;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Upload image;

    @NotBlank
    @Size(max = 255)
    @Column(name = "token_id", unique = true, nullable = false, length = 255)
    private String tokenId;

    @PositiveOrZero
    @Digits(integer = 10, fraction = 2)
    private Double price;

    @Builder.Default
    @Column(name = "on_auction", nullable = false)
    private boolean onAuction = false;

    @FutureOrPresent(message = "Auction start date must be in the present or future")
    @Column(name = "auction_start_date")
    private LocalDateTime auctionStartDate;

    @PositiveOrZero
    @Digits(integer = 10, fraction = 2)
    @Column(name = "auction_starting_price")
    private Double auctionStartingPrice;

    @FutureOrPresent(message = "Auction end date must be in the present or future")
    @Column(name = "auction_end_date")
    private LocalDateTime auctionEndDate;

    @PositiveOrZero
    @Column(name = "likes_count", nullable = false)
    private Integer likesCount = 0;

    @PositiveOrZero
    @Column(name = "views_count", nullable = false)
    private Integer viewsCount = 0;

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
    @NotNull(message = "Category is required")
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Crypto type is required")
    @Column(nullable = false)
    private CryptoType cryptoType;

    @OneToMany(mappedBy = "nft", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offer> offers = new ArrayList<>();
}
