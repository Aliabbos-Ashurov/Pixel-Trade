package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  12:56
 **/
@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Transaction extends Auditable {

    @PositiveOrZero
    @Column(nullable = false)
    private Double price;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "nft_id", nullable = false)
    private NFT nft;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CryptoType cryptoType;

    @Builder.Default
    @Column(name = "is_auction_transaction")
    private boolean isAuctionTransaction = false;
}
