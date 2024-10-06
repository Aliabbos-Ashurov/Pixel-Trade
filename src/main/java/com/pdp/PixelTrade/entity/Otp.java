package com.pdp.PixelTrade.entity;

import com.pdp.PixelTrade.enums.OtpType;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  15:01
 **/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "otp")
@SuperBuilder(toBuilder = true)
public class Otp extends BaseEntity {

    @Column(nullable = false, updatable = false)
    private String recipient;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private OtpType type;

    @Column(nullable = false, updatable = false)
    private String code;

    @Builder.Default
    @FutureOrPresent
    @Column(name = "expires_at", nullable = false, updatable = false)
    private LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(2);

    @Builder.Default
    @Column(nullable = false)
    private boolean used = false;
}
