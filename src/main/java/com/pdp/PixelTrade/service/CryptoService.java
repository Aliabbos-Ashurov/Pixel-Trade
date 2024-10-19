package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.transaction.request.CryptoCreateDTO;
import com.pdp.PixelTrade.dto.transaction.response.CryptoResponseDTO;
import com.pdp.PixelTrade.entity.Crypto;
import com.pdp.PixelTrade.entity.Upload;
import com.pdp.PixelTrade.enums.AwsPackage;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.mapper.CryptoMapper;
import com.pdp.PixelTrade.repository.CryptoRepository;
import com.pdp.PixelTrade.service.aws.S3Service;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  12:22
 **/
@Service
@RequiredArgsConstructor
public class CryptoService {

    private final S3Service s3Service;
    private final UploadService uploadService;
    private final CryptoRepository cryptoRepository;
    private final CryptoMapper cryptoMapper;

    @Async
    @Transactional
    public void save(@NotNull CryptoCreateDTO dto) {

        String imageURL = s3Service.uploadFile(dto.image(), AwsPackage.CRYPTO);
        Crypto crypto = cryptoMapper.toCrypto(dto);

        Upload upload = Upload.builder()
                .size(dto.image().getSize())
                .fileType(StringUtils.getFilenameExtension(dto.image().getOriginalFilename()))
                .originalName(dto.image().getName())
                .generatedName(imageURL.substring(imageURL.lastIndexOf("/") + 1))
                .url(imageURL)
                .build();

        crypto.setImage(upload);
        cryptoRepository.save(crypto);
    }


    public Optional<BigDecimal> getFeePercentage(@NotNull CryptoType type) {
        return cryptoRepository.getFeePercentage(type.getCode());
    }

    public Optional<Crypto> findByName(@NotNull String name) {
        return cryptoRepository.findByName(name);
    }

    public Optional<Crypto> findBySymbol(@NotNull String symbol) {
        return cryptoRepository.findBySymbol(symbol);
    }

    public ApiResponse<List<CryptoResponseDTO>> findAll() {
        return ApiResponse.ok(cryptoRepository.findAll().stream()
                .map(cryptoMapper::toCryptoResponseDTO)
                .toList());
    }

    public void updateFeePercentage(@NotNull Long id, @NotNull BigDecimal feePercentage) {
        cryptoRepository.updateFeePercentage(id, feePercentage);
    }
}
