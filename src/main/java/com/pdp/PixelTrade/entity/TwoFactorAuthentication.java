package com.pdp.PixelTrade.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  15:24
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "two_factor_authentication")
public class TwoFactorAuthentication extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private String passkey;

    @Column(name = "authenticator_app")
    private String authenticatorApp;

    @Email
    @NotBlank
    @Column(name = "backup_mail", unique = true)
    private String backupMail;

    @Builder.Default
    @Column(name = "is_backup_enabled")
    private boolean isBackupEnabled = false;
}
