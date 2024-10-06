package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.Otp;
import com.pdp.PixelTrade.enums.OtpType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reactor.util.annotation.NonNullApi;

import java.util.List;
import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {

    @Query("FROM Otp o WHERE o.code = :code AND o.recipient = :recipient AND o.used = FALSE AND o.deleted = FALSE")
    Optional<Otp> findActive(@NotNull @Param("code") String code, @NotNull @Param("recipient") String recipient);


    @Query(""" 
            SELECT COUNT(o) > 0 FROM Otp o WHERE o.recipient = :recipient AND o.expiresAt > CURRENT_TIMESTAMP
            AND o.used = FALSE AND o.deleted = FALSE
            """)
    boolean hasActiveOtp(@Param("recipient") String recipient);

    @Query("FROM Otp o WHERE o.id = :id AND o.deleted = FALSE")
    Optional<Otp> findById(@NotNull @Param("id") Long id);

    @Query("FROM Otp o WHERE o.code = :code AND o.deleted = FALSE")
    Optional<Otp> findByCode(@NotNull String code);

    @Query("FROM Otp o WHERE o.code = :code AND o.used = FALSE AND o.deleted = FALSE")
    Optional<Otp> findByCodeAndNotUsed(@NotNull String code);

    @Query("FROM Otp o WHERE o.expiresAt < CURRENT_TIMESTAMP AND o.deleted = FALSE")
    List<Otp> findExpiredOtps();

    @Query("FROM Otp o WHERE o.used = FALSE AND o.deleted = FALSE")
    List<Otp> findAllActiveOtps();

    @Query("SELECT COUNT(o) FROM Otp o WHERE o.type = :type AND o.used = FALSE")
    long countUnusedOtpsByType(@NotNull @Param("type") OtpType type);

    @Modifying
    @Query("UPDATE Otp o SET o.used = TRUE WHERE o.code = :code")
    void markOtpAsUsed(@Param("code") String code);

    @Modifying
    @Query("UPDATE Otp o SET o.used = TRUE, o.deleted = TRUE WHERE o.code = :code")
    void markOtpAsUsedAndSoftDelete(@Param("code") String code);

    @Modifying
    @Query("Update Otp o SET o.deleted = TRUE WHERE o.expiresAt < CURRENT_TIMESTAMP")
    void softDeleteExpiredOtps();

    @Modifying
    @Query("DELETE FROM Otp o WHERE o.expiresAt < CURRENT_TIMESTAMP")
    void deleteExpiredOtps();
}