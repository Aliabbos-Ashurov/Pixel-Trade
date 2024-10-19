package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.entity.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UploadRepository extends JpaRepository<Upload, Long> {

    @Query("""
            FROM Upload u
            WHERE u.generatedName = :generatedName
            AND u.deleted = FALSE
            """)
    Optional<Upload> findByGeneratedName(String generatedName);

    @Query("""
            FROM Upload u
            WHERE u.originalName = :originalName
            AND u.deleted = FALSE
            """)
    Optional<Upload> findByOriginalName(String originalName);


    @Query("""
            FROM Upload u
            WHERE u.url = :url
            AND u.deleted = FALSE
            """)
    Optional<Upload> findByUrl(String url);
}