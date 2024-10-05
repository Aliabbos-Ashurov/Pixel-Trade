package com.pdp.PixelTrade.entity.transactions;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.CardType;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.CurrencyType;
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
@Entity
public class P2PMarket extends Auditable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 38, scale = 10)
    private BigDecimal perPrice;                              // 74.000

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type", nullable = false)
    private CurrencyType currencyType;                        // UZS

    @Enumerated(EnumType.STRING)
    @Column(name = "crypto_type", nullable = false)
    private CryptoType cryptoType;                            // TON

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 38, scale = 10)
    private BigDecimal amount;                                // available balance   100 TON


    @Enumerated(EnumType.STRING)
    private CardType cardType;                                // UZCARD,  HUMO ,  WALLET


    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
