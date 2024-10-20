package com.pdp.PixelTrade.entity.wallet;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.enums.CardType;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.P2POrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  12:13
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "p2p_order")
@Entity
public class P2POrder extends Auditable {

    @DecimalMin(value = "0.0")
    @Column(nullable = false, precision = 38, scale = 8, updatable = false)
    private BigDecimal amount;

    @DecimalMin(value = "0.0")
    @Column(nullable = false, precision = 38, scale = 8, updatable = false)
    private BigDecimal perPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "crypto_type", nullable = false, updatable = false)
    private CryptoType cryptoType;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type", nullable = false, updatable = false)
    private CardType cardType;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private P2POrderStatus orderStatus = P2POrderStatus.WAITING;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private Wallet wallet;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private P2PMarket market;
}
