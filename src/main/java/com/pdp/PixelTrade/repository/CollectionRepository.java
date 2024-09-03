package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  13:59
 **/
public interface CollectionRepository extends JpaRepository<Collection, Long> {

    List<Collection> findByOwnerId(Long ownerId);

    @Query("FROM Collection WHERE isVerified = ?1")
    List<Collection> findByVerified(boolean verified);

    List<Collection> findByNameContainingIgnoreCase(String name);
}
