package com.pdp.PixelTrade.entity.wallet;

import com.pdp.PixelTrade.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  10:03
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
public class Fee extends BaseEntity {

    @OneToOne
    @JoinColumn(nullable = false, updatable = false, referencedColumnName = "id")
    private Transaction transaction;

    @DecimalMin("0.0")
    @Column(updatable = false, nullable = false, precision = 38, scale = 8)     // fee = amount * percentage;
    private BigDecimal fee;

    @DecimalMin("0.0")
    @Column(name = "fee_percentage", updatable = false, nullable = false, precision = 38, scale = 8)
    private BigDecimal feePercentage;

}
