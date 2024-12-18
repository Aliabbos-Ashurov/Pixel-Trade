package com.pdp.PixelTrade.entity.wallet;

import com.pdp.PixelTrade.entity.BaseEntity;
import com.pdp.PixelTrade.entity.nft.TransactionNFT;
import com.pdp.PixelTrade.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 29/September/2024  15:57
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "wallet_history")
@Entity
public class WalletHistory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Wallet wallet;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false, updatable = false)
    private TransactionType transactionType;

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 38, scale = 8, updatable = false)
    private BigDecimal amount;

    @Column(updatable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "id", updatable = false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "transaction_nft_id", referencedColumnName = "id", updatable = false)
    private TransactionNFT transactionNFT;
}
