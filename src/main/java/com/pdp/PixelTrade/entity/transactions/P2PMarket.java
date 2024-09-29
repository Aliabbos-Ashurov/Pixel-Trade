package com.pdp.PixelTrade.entity.transactions;

import com.pdp.CryptoType;
import com.pdp.PixelTrade.entity.Auditable;
import jakarta.persistence.*;
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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private BigDecimal amount;

    @Column(name = "crypto_type")
    private CryptoType cryptoType;

    private BigDecimal perPrice;

    @Column(name = "description")
    private String description;
}
