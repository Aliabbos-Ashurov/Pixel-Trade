package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}