package com.pdp.PixelTrade.entity.transactions;

import com.pdp.PixelTrade.entity.BaseEntity;
import com.pdp.PixelTrade.enums.TransactionStatus;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 28/September/2024  20:34
 **/
@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Transaction extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_wallet_id", nullable = false, referencedColumnName = "id")
    private Wallet fromWallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_wallet_id", nullable = false, referencedColumnName = "id")
    private Wallet toWallet;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @NotNull
    @PositiveOrZero
    @DecimalMin("0.0")
    private BigDecimal amount;

    @PositiveOrZero
    @DecimalMin("0.0")
    private BigDecimal fee = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status", nullable = false)
    private TransactionStatus transactionStatus = TransactionStatus.PENDING;

    @Column(name = "error_message")
    private String errorMessage;
}
