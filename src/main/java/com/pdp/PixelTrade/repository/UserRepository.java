package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            FROM User u
            WHERE u.username = :username
            AND u.deleted = FALSE
            """)
    User findByUsername(@Param("username") String username);

    User findByIdAndDeletedFalse(@NotNull Long id);
}