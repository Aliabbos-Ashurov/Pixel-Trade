package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.request.transaction.CryptoCreateDTO;
import com.pdp.PixelTrade.dto.response.transaction.CryptoResponseDTO;
import com.pdp.PixelTrade.entity.Crypto;
import com.pdp.PixelTrade.enums.AwsPackage;
import com.pdp.PixelTrade.mapper.CryptoMapper;
import com.pdp.PixelTrade.repository.CryptoRepository;
import com.pdp.PixelTrade.service.aws.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

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
    private final CryptoRepository cryptoRepository;
    private final CryptoMapper cryptoMapper;

    public void save(CryptoCreateDTO dto) {
        String imageURL = s3Service.uploadFile(dto.image(), AwsPackage.PUBLIC);
        Crypto crypto = cryptoMapper.toCrypto(dto);
        crypto.setImageURL(imageURL);
        cryptoRepository.save(crypto);
    }

    public Optional<Crypto> findByName(String name) {
        return cryptoRepository.findByName(name);
    }

    public Optional<Crypto> findBySymbol(String symbol) {
        return cryptoRepository.findBySymbol(symbol);
    }

    public boolean existsBySymbol(String symbol) {
        return cryptoRepository.existsBySymbol(symbol);
    }

    public boolean existsByName(String name) {
        return cryptoRepository.existsByName(name);
    }

    public ApiResponse<List<CryptoResponseDTO>> findAll() {
        return ApiResponse.ok(cryptoRepository.findAll().stream()
                .map(cryptoMapper::toCryptoResponseDTO)
                .toList());
    }

    public List<Crypto> findAllOrderByFeePercentageDesc() {
        return cryptoRepository.findAllOrderByFeePercentageDesc();
    }

    public void updateFeePercentage(@Param("id") Long id, @Param("feePercentage") BigDecimal feePercentage) {
        cryptoRepository.updateFeePercentage(id, feePercentage);
    }
}
