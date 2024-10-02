package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 02/October/2024  09:10
 **/
public interface AuthRepository extends JpaRepository<User, Long> {

    @Query("FROM User u WHERE u.username = :username AND u.deleted = false")
    Optional<User> findByUsername(String username);

}
