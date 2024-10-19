package com.pdp.PixelTrade.entity.wallet;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.Upload;
import com.pdp.PixelTrade.entity.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  11:59
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "seller")
@Entity
public class Seller extends Auditable {

    @Column(nullable = false, unique = true)
    private String name;

    @Builder.Default
    @Column(name = "trades_count", nullable = false)
    private Long tradesCount = 0L;

    @Column(name = "rating", precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @OneToOne
    @JoinColumn(name = "profile_picture_url")
    private Upload profilePictureUrl;

    @OneToOne
    private User user;
}
