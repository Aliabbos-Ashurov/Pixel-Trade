package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.User;
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

    User findByIdAndDeletedFalse(Long id);

    @Query("""
            SELECT COUNT(u) > 0
            FROM User u
            WHERE u.email = :email
            AND u.deleted = FALSE
            """)
    boolean existEmail(@Param("email") String email);
}