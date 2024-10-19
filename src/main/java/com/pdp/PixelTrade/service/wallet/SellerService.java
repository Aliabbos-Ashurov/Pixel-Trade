package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.transaction.response.SellerResponseDTO;
import com.pdp.PixelTrade.entity.wallet.Seller;
import com.pdp.PixelTrade.exceptions.ResourceNotFoundException;
import com.pdp.PixelTrade.mapper.SellerMapper;
import com.pdp.PixelTrade.repository.SellerRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  13:13
 **/
@Service
@RequiredArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;
    private final SellerMapper sellerMapper;

    public ApiResponse<List<SellerResponseDTO>> findAll() {
        return ApiResponse.ok(
                sellerRepository.findAllSellers().stream()
                        .map(sellerMapper::toSellerResponseDTO)
                        .toList()
        );
    }

    public ApiResponse<SellerResponseDTO> findByName(@NotNull String name) {
        return ApiResponse.ok(
                sellerMapper.toSellerResponseDTO(sellerRepository.findByName(name))
        );
    }

    public Seller findBySellerId(@NotNull Long sellerId) {
        return sellerRepository.findBySellerId(sellerId).orElseThrow(
                () -> new ResourceNotFoundException("Seller not found with sellerId: {0}", sellerId));
    }
}
