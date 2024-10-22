package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.SellerResponseDTO;
import com.pdp.PixelTrade.entity.wallet.Seller;
import com.pdp.PixelTrade.exceptions.ResourceNotFoundException;
import com.pdp.PixelTrade.mapper.SellerMapper;
import com.pdp.PixelTrade.repository.SellerRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  13:13
 **/
@Service
public class SellerService extends AbstractService<SellerRepository, SellerMapper> {

    public SellerService(SellerRepository repository, SellerMapper mapper) {
        super(repository, mapper);
    }

    public Response<List<SellerResponseDTO>> findAll() {
        return Response.ok(
                repository.findAllSellers().stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    public Response<SellerResponseDTO> findByName(@NotNull String name) {
        return Response.ok(
                mapper.toDTO(repository.findByName(name))
        );
    }

    public Seller findBySellerId(@NotNull Long sellerId) {
        return repository.findBySellerId(sellerId).orElseThrow(
                () -> new ResourceNotFoundException("Seller not found with sellerId: {0}", sellerId));
    }
}
