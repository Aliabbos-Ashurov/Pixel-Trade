package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 02/September/2024  13:13
 **/
@Entity
@Table(name = "offer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Offer extends Auditable {

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 38, scale = 8, updatable = false)
    private BigDecimal amount;

    @PastOrPresent(message = "Offer date must be in the present or past")
    @Column(name = "offer_date", nullable = false, updatable = false)
    private LocalDateTime offerDate;

    @ManyToOne
    @JoinColumn(name = "nft_id", nullable = false, updatable = false)
    private NFT nft;

    @ManyToOne
    @JoinColumn(name = "bidder_id", nullable = false)
    private User bidder;
}
