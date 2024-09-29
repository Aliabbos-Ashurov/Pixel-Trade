package com.pdp.PixelTrade.entity.transactions;

import com.pdp.PixelTrade.entity.Auditable;
import com.pdp.PixelTrade.enums.CurrencyType;
import com.pdp.PixelTrade.enums.IdentificationLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    private BigDecimal balance;
    private CurrencyType currency;
    private String address;
    private String password;
    private IdentificationLevel status;
    private boolean twoFactorEnabled;
    private boolean notificationsEnabled;

    @Column(name = "max_withdrawal_limit")
    private BigDecimal maxWithdrawalLimit;

    @Column(name = "min_withdrawal_limit")
    private BigDecimal minWithdrawalLimit;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CryptoAsset> cryptoAssets;

}
