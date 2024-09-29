package com.pdp.PixelTrade.entity.transactions;

import com.pdp.CryptoType;
import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "crypto_type")
    private CryptoType cryptoType;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal perPrice;

    @Size(max = 500)
    @Column(name = "description")
    private String description;
}
