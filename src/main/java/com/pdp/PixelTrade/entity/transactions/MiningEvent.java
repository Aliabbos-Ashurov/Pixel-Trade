package com.pdp.PixelTrade.entity.transactions;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 04/October/2024  09:29
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "mining_event")
public class MiningEvent extends Auditable {

    @Enumerated(EnumType.STRING)
    @Column(name = "crypto_type", nullable = false, updatable = false)
    private CryptoType cryptoType;

    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0")
    @Digits(integer = 28, fraction = 10, message = "Amount precision must not exceed 38 digits and scale must be 10 or less")
    @Column(nullable = false, precision = 38, scale = 10)
    private BigDecimal amount;

    @NotNull(message = "Start time is required")
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @NotNull(message = "End time is required")
    @FutureOrPresent(message = "End time must be in the present or future")
    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @DecimalMin(value = "0.0", message = "Entry fee must be zero or positive")
    @Digits(integer = 28, fraction = 10, message = "Entry fee precision must not exceed 38 digits and scale must be 10 or less")
    @Column(name = "entry_fee", nullable = false, precision = 38, scale = 10)
    private BigDecimal entryFee;

    @PositiveOrZero(message = "Max participants must be zero or positive")
    @Column(name = "max_participants", nullable = false)
    private int maxParticipants;

    @OneToMany(mappedBy = "miningEvent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CloudMining> miningActivities;

    @Column(name = "additional_info")
    private String additionalInfo;

    public boolean canUserCompete(int currentParticipants) {
        return currentParticipants < maxParticipants;
    }
}
