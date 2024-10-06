package com.pdp.PixelTrade.entity.transactions;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 28/September/2024  20:25
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
public class CryptoAsset extends Auditable {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", updatable = false, referencedColumnName = "id")
    private Wallet wallet;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "crypto_type", updatable = false)
    private CryptoType cryptoType;

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 38, scale = 8)
    private BigDecimal amount;

    /*@Column(nullable = false, updatable = false, unique = true)
    private String address;*/

    @Builder.Default
    @Column(name = "is_locked")
    private Boolean isLocked = false;

    @Column(name = "locked_reason", columnDefinition = "TEXT")
    private String lockedReason;
}
