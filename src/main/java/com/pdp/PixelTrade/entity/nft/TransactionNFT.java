package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.Transactional;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  12:56
 **/
@Entity
@Table(name = "transaction_nft")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class TransactionNFT extends Auditable implements Transactional {

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 38, scale = 8, updatable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "nft_id", nullable = false, updatable = false)
    private NFT nft;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private CryptoType cryptoType;

    @Builder.Default
    @Column(name = "is_auction_transaction", nullable = false)
    private boolean isAuctionTransaction = false;
}
