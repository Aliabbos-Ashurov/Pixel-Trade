package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.TwoFactorAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwoFactorAuthenticationRepository extends JpaRepository<TwoFactorAuthentication, Long> {
}