package com.pdp.PixelTrade.entity.transactions;

import com.pdp.PixelTrade.annotation.ValidWallet;
import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.enums.CurrencyType;
import com.pdp.PixelTrade.enums.IdentificationLevel;
import com.pdp.PixelTrade.utils.WalletAddressGenerator;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 28/September/2024  19:58
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
public class Wallet extends Auditable {

    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be positive")
    @Column(nullable = false, precision = 38, scale = 10)
    private BigDecimal balance;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CurrencyType currency = CurrencyType.USD;

    @ValidWallet
    @Builder.Default
    @Column(nullable = false, unique = true, updatable = false)
    private String address = WalletAddressGenerator.generate();

    @Pattern(regexp = "\\d{4}|\\d{6}", message = "Password must be 4 or 6 digits")
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IdentificationLevel status;

    @Builder.Default
    @Column(name = "two_factor_enabled", nullable = false)
    private boolean twoFactorEnabled = false;

    @Builder.Default
    @Column(name = "notifications_enabled", nullable = false)
    private boolean notificationsEnabled = true;

    @Builder.Default
    @DecimalMin(value = "0.0", message = "Max withdrawal limit must be non-negative")
    @Column(name = "max_withdrawal_limit")
    private BigDecimal maxWithdrawalLimit = BigDecimal.ZERO;

    @Builder.Default
    @DecimalMin(value = "0.0", message = "Min withdrawal limit must be non-negative")
    @Column(name = "min_withdrawal_limit")
    private BigDecimal minWithdrawalLimit = BigDecimal.ZERO;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<CryptoAsset> cryptoAssets;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
}
