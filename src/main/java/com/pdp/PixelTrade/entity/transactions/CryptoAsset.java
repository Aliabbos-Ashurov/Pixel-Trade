package com.pdp.PixelTrade.entity.transactions;

import com.pdp.CryptoType;
import com.pdp.PixelTrade.entity.Auditable;
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
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Wallet wallet;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "crypto_type")
    private CryptoType cryptoType;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal amount;

    @Size(max = 100)
    private String address;

    @Column(name = "is_locked")
    private boolean isLocked;

    @Size(max = 255)
    @Column(name = "locked_reason")
    private String lockedReason;
}
