package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:01
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
