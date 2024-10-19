package com.pdp.PixelTrade.entity.wallet;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.enums.CardType;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.CurrencyType;
import com.pdp.PixelTrade.enums.P2PType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 28/September/2024  20:31
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "p2p_market")
@Entity
public class P2PMarket extends Auditable {

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    private Seller seller;

    @DecimalMin("0.0")
    @Column(name = "per_price", nullable = false, precision = 38, scale = 8)
    private BigDecimal perPrice;                              // 74.000

    @Enumerated(EnumType.STRING)
    @Column(name = "crypto_type", nullable = false)
    private CryptoType cryptoType;                            // TON

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 38, scale = 8)
    private BigDecimal amount;                                // available balance   100 TON

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private CurrencyType currencyType;                        // UZS da olaman / sotaman.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)              // shu karta turi orqali
    private CardType cardType;

    @Enumerated(EnumType.STRING)
    @Column(name = "p2p_type", nullable = false, updatable = false)
    private P2PType p2PType;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
