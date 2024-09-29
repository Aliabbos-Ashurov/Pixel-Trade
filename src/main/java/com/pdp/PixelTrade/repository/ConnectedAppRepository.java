package com.pdp.PixelTrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  13:59
 **/
public interface ConnectedAppRepository extends JpaRepository<ConnectedApp, Long> {

    @Query("SELECT c FROM ConnectedApp c WHERE c.collection.id = ?1")
    List<ConnectedApp> findConnectedAppByCollectionId(Long collectionId);
}
