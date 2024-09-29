package com.pdp.PixelTrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:01
 **/
public interface UploadRepository extends JpaRepository<Upload, Long> {

    Optional<Upload> findByGeneratedName(String generatedName);

    Optional<Upload> findByOriginalName(String originalName);
}
