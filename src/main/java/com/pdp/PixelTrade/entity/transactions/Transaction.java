package com.pdp.PixelTrade.entity.transactions;

import com.pdp.PixelTrade.entity.BaseEntity;
import com.pdp.PixelTrade.enums.TransactionStatus;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @JoinColumn(name = "from_wallet_id", nullable = false, updatable = false, referencedColumnName = "id")
    private Wallet fromWallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_wallet_id", nullable = false, updatable = false, referencedColumnName = "id")
    private Wallet toWallet;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false, updatable = false)
    private TransactionType transactionType;

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 38, scale = 8)
    private BigDecimal amount;

    @Builder.Default
    @DecimalMin("0.0")
    @Column(nullable = false, precision = 38, scale = 8)
    private BigDecimal fee = BigDecimal.ZERO;                    //  fee = amount * feePercentage

    @Builder.Default
    @Column(name = "fee_percentage", nullable = false)
    private BigDecimal feePercentage = BigDecimal.ZERO;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status", nullable = false)
    private TransactionStatus transactionStatus = TransactionStatus.PENDING;

    @Column(name = "image_url", updatable = false)
    private String imageURL;

    @Column(name = "qrcode_url", updatable = false)
    private String qrCodeURL;

    @FutureOrPresent
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    @Column(name = "metadata", columnDefinition = "TEXT")
    private String metadata;

    @Column(name = "error_message")
    private String errorMessage;
}
