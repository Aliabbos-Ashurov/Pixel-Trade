package com.pdp.PixelTrade.entity.nft;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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

    @PositiveOrZero
    @Column(nullable = false)
    private Double amount;

    @Column(name = "offer_date", nullable = false)
    private LocalDateTime offerDate;

    @ManyToOne
    @JoinColumn(name = "nft_id", nullable = false)
    private NFT nft;

    @ManyToOne
    @JoinColumn(name = "bidder_id", nullable = false)
    private User bidder;
}