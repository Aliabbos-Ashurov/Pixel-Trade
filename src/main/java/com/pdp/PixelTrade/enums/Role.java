package com.pdp.PixelTrade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.pdp.PixelTrade.enums.Permission.*;

/**
 * @author Aliabbos Ashurov
 * @since 29/September/2024  15:30
 **/
@Getter
@AllArgsConstructor
public enum Role {
    USER(Set.of(
            VIEW_WALLET,
            DEPOSIT,
            WITHDRAW,
            TRANSFER,
            VIEW_CRYPTO_PORTFOLIO,
            BUY_CRYPTO,
            SELL_CRYPTO,
            VIEW_CRYPTO_HISTORY,
            CREATE_NFT,
            VIEW_NFT,
            TRANSFER_NFT
    )),

    ADMIN(Set.of(
            MANAGE_USERS,
            MANAGE_PERMISSIONS,
            VIEW_STATISTICS,
            VIEW_LOGS
    )),

    SUPER_ADMIN(Set.of(
            MANAGE_USERS,
            MANAGE_PERMISSIONS,
            VIEW_STATISTICS,
            VIEW_LOGS,
            CREATE_NFT,
            DELETE_NFT
    ));

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getAccess()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}

