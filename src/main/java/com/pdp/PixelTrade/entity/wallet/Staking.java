package com.pdp.PixelTrade.entity.wallet;

import com.pdp.PixelTrade.entity.BaseEntity;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  11:53
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
public class Staking extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false, referencedColumnName = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private CryptoType cryptoType;

    @ManyToOne
    @JoinColumn(name = "staking_event_id", nullable = false, updatable = false, referencedColumnName = "id")
    private StakingEvent stakingEvent;

    @Column(name = "amount_staked", nullable = false, updatable = false, precision = 38, scale = 8)
    private BigDecimal amountStaked;

    @Column(updatable = false, precision = 38, scale = 8)
    private BigDecimal earned;

    @Column(name = "stake_start", nullable = false, updatable = false)
    private LocalDateTime stakeStart;

    @Column(name = "stake_end")
    private LocalDateTime stakeEnd;
}
