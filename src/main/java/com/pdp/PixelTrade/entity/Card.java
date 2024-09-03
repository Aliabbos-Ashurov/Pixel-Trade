package com.pdp.PixelTrade.entity;

import com.pdp.PixelTrade.enums.CardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  13:17
 **/
@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Card extends Auditable {

    @NotBlank
    @Column(nullable = false, unique = true)
    private String cardNumber;

    @FutureOrPresent
    @Column(nullable = false)
    private LocalDate expiryDate;

    @NotBlank
    @Column(nullable = false)
    private String cardHolderName;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType cardType;
}
