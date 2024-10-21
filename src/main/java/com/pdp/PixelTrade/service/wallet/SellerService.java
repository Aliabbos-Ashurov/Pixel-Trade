package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.Response;
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

    public Response<List<SellerResponseDTO>> findAll() {
        return Response.ok(
                sellerRepository.findAllSellers().stream()
                        .map(sellerMapper::toSellerResponseDTO)
                        .toList()
        );
    }

    public Response<SellerResponseDTO> findByName(@NotNull String name) {
        return Response.ok(
                sellerMapper.toSellerResponseDTO(sellerRepository.findByName(name))
        );
    }

    public Seller findBySellerId(@NotNull Long sellerId) {
        return sellerRepository.findBySellerId(sellerId).orElseThrow(
                () -> new ResourceNotFoundException("Seller not found with sellerId: {0}", sellerId));
    }
}
