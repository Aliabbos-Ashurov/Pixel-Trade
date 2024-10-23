package com.pdp.PixelTrade.service;

import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 23/October/2024  10:44
 **/
public interface MailService {

    void sendPasswordChanging(@NotNull String recipient);

    void sendBackupMail(@NotNull Long userId, @NotNull String mail);

    void verifyBackupMail(@NotNull Long userId, @NotNull String mail);
}
