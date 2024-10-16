package com.pdp.PixelTrade.entity.wallet;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.Upload;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.StakingEventStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  11:01
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "staking_event")
@Entity
public class StakingEvent extends Auditable {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private CryptoType cryptoType;

    @Column(name = "reward_percentage", nullable = false, precision = 5, scale = 2, updatable = false)
    private BigDecimal rewardPercentage;

    @Column(name = "minimum_stake", nullable = false, precision = 38, scale = 8, updatable = false)
    private BigDecimal minimumStake;

    @Column(name = "start_date", nullable = false, updatable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false, updatable = false)
    private LocalDateTime endDate;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "event_status", nullable = false)
    private StakingEventStatus eventStatus = StakingEventStatus.WAITING;

    @OneToOne
    private Upload upload;

}
