package com.pdp.PixelTrade.entity;

import com.pdp.PixelTrade.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aliabbos Ashurov
 * @since 29/September/2024  14:10
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "users")
public class User extends Auditable {

    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @Email
    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Column(name = "wallet_address")
    private String walletAddress;

    @Builder.Default
    @Column(name = "is_active")
    private boolean isActive = false;

    @Builder.Default
    @Column(name = "is_premium")
    private boolean isPremium = false;

    @Builder.Default
    @Column(nullable = false)
    private Role role = Role.USER;
}
