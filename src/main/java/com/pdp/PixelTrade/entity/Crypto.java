package com.pdp.PixelTrade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  12:15
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Crypto extends Auditable {

    @Column(unique = true, nullable = false, updatable = false)
    private String name;

    @Column(unique = true, nullable = false, updatable = false)
    private String symbol;

    @Column(name = "image_url", unique = true, nullable = false)
    private String imageURL;

    @DecimalMin("0.0")
    @Column(name = "fee_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal feePercentage;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}