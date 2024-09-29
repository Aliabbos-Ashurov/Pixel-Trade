package com.pdp.PixelTrade.entity.transactions;

import com.pdp.PixelTrade.entity.BaseEntity;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Aliabbos Ashurov
 * @since 29/September/2024  15:57
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
public class WalletHistory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "id", nullable = false)
    private Wallet wallet;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal amount;

    private BigDecimal balanceAfterTransaction;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", referencedColumnName = "id", nullable = false)
    private Transaction transaction;
}
