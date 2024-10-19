package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.Otp;
import com.pdp.PixelTrade.enums.OtpType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {

    @Query("""
            FROM Otp o
            WHERE o.code = :code
            AND o.recipient = :recipient
            AND o.used = FALSE
            AND o.deleted = FALSE
            """)
    Optional<Otp> findActive(@Param("code") String code, @Param("recipient") String recipient);

    @Query("""
            SELECT COUNT(o) > 0 FROM Otp o
            WHERE o.recipient = :recipient
            AND o.type = :type
            AND o.used = TRUE
            AND o.deleted = FALSE
            """)
    boolean isOtpUsedByRecipient(@Param("recipient") String recipient,
                                 @Param("type") OtpType type);

    @Query(""" 
            SELECT COUNT(o) > 0 FROM Otp o
            WHERE o.recipient = :recipient
            AND o.expiresAt > CURRENT_TIMESTAMP
            AND o.used = FALSE
            AND o.deleted = FALSE
            """)
    boolean hasActiveOtp(@Param("recipient") String recipient);

    @Query("""
            FROM Otp o
            WHERE o.id = :id
            AND o.deleted = FALSE
            """)
    Optional<Otp> findById(@Param("id") Long id);

    @Query("""
            FROM Otp o
            WHERE o.code = :code
            AND o.deleted = FALSE
            """)
    Optional<Otp> findByCode(String code);

    @Query("""
            FROM Otp o
            WHERE o.code = :code
            AND o.used = FALSE
            AND o.deleted = FALSE
            """)
    Optional<Otp> findByCodeAndNotUsed(String code);

    @Query("""
            FROM Otp o
            WHERE o.expiresAt < CURRENT_TIMESTAMP
            AND o.deleted = FALSE
            """)
    List<Otp> findExpiredOtps();

    @Query("""
            FROM Otp o
            WHERE o.used = FALSE
            AND o.deleted = FALSE
            """)
    List<Otp> findAllActiveOtps();

    @Query("""
            SELECT COUNT(o) FROM Otp o
            WHERE o.type = :type
            AND o.used = FALSE
            """)
    long countUnusedOtpsByType(@Param("type") OtpType type);

    @Modifying
    @Query("""
            UPDATE Otp o
            SET o.used = TRUE
            WHERE o.recipient = :recipient
            AND o.code = :code
            """)
    void markOtpAsUsed(@Param("recipient") String recipient, @Param("code") String code);

    @Modifying
    @Query("""
            UPDATE Otp o
            SET o.used = TRUE, o.deleted = TRUE
            WHERE o.recipient = :recipient
            AND o.code = :code
            """)
    void markOtpAsUsedAndSoftDelete(@Param("recipient") String recipient, @Param("code") String code);

    @Modifying
    @Query("""
            Update Otp o SET o.deleted = TRUE
            WHERE o.expiresAt < CURRENT_TIMESTAMP
            """)
    void softDeleteExpiredOtps();

    @Modifying
    @Query("""
            DELETE FROM Otp o
            WHERE o.expiresAt < CURRENT_TIMESTAMP
            """)
    void deleteExpiredOtps();
}