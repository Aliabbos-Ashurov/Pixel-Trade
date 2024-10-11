package com.pdp.PixelTrade.entity.wallet;

import com.pdp.PixelTrade.entity.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 11/October/2024  09:15
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "wallet_suspicion_record")
public class WalletSuspicionRecord extends Auditable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id", nullable = false, unique = true)
    private Wallet wallet;

    @Column(name = "suspension_reason", nullable = false, columnDefinition = "TEXT")
    private String reason;

    @Column(name = "suspended_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime suspendedAt;

    @Column(name = "reactivated_at")
    private LocalDateTime reactivatedAt;

}
