package com.pdp.PixelTrade.entity.wallet;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.Transactional;
import com.pdp.PixelTrade.entity.Upload;
import com.pdp.PixelTrade.enums.CryptoType;
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
public class Transaction extends Auditable implements Transactional {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_wallet", nullable = false, updatable = false, referencedColumnName = "id")
    private Wallet fromWallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_wallet", nullable = false, updatable = false, referencedColumnName = "id")
    private Wallet toWallet;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false, updatable = false)
    private TransactionType transactionType;

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 38, scale = 8)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "crypto_type", nullable = false, updatable = false)
    private CryptoType cryptoType;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status", nullable = false)
    private TransactionStatus transactionStatus = TransactionStatus.PENDING;

    @FutureOrPresent
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    @Column(name = "metadata", columnDefinition = "TEXT")
    private String metadata;

    @Column(name = "error_message")
    private String errorMessage;

    @OneToOne
    @JoinColumn(name = "qr_code", referencedColumnName = "id", updatable = false)
    private Upload qrCode;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Fee fee;

}
