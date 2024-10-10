package com.pdp.PixelTrade.entity.wallet;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.MiningStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 04/October/2024  09:09
 **/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "cloud_mining")
public class CloudMining extends Auditable {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private MiningEvent miningEvent;

    @Column(name = "started_time", nullable = false)
    private LocalDateTime startedTime;

    @Builder.Default
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MiningStatus status = MiningStatus.ACTIVE;

    @Builder.Default
    @DecimalMin("0.0")
    @PositiveOrZero(message = "Earned amount must be zero or positive")
    @Column(name = "earned_amount", nullable = false, precision = 38, scale = 8)
    private BigDecimal earnedAmount = BigDecimal.ZERO;
}
