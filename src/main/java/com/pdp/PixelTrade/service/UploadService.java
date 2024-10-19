package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.entity.Upload;
import com.pdp.PixelTrade.exceptions.ResourceNotFoundException;
import com.pdp.PixelTrade.repository.UploadRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  13:43
 **/
@Service
@RequiredArgsConstructor
public class UploadService {
    private final UploadRepository uploadRepository;

    public Upload findByGeneratedName(@NotNull String generatedName) {
        return uploadRepository.findByGeneratedName(generatedName)
                .orElseThrow(() -> new ResourceNotFoundException("Upload not found with generated name: {0}", generatedName));
    }

    public Upload findByOriginalName(@NotNull String originalName) {
        return uploadRepository.findByOriginalName(originalName)
                .orElseThrow(() -> new ResourceNotFoundException("Upload not found with original name: {0}", originalName));
    }

    public Upload findByUrl(@NotNull String url) {
        return uploadRepository.findByUrl(url)
                .orElseThrow(() -> new ResourceNotFoundException("Upload not found with url: {0}", url));
    }
}
