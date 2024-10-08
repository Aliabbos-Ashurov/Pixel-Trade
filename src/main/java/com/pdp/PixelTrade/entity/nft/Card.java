package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.CardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 13, max = 19)
    @Column(nullable = false, unique = true)
    private String cardNumber;

    @FutureOrPresent(message = "Expiry date must be in the present or future")
    @Column(nullable = false)
    private LocalDate expiryDate;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String cardHolderName;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Card type is required")
    @Column(nullable = false)
    private CardType cardType;
}
