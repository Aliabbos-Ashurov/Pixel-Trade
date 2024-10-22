package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.request.P2PMarketCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.P2PMarketUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.P2PMarketResponseDTO;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.mapper.P2PMarketMapper;
import com.pdp.PixelTrade.repository.wallet.P2PMarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:21
 **/
@Service
@RequiredArgsConstructor
public class P2PMarketServiceImpl implements P2PMarketService {
    private final P2PMarketRepository p2PMarketRepository;
    private final P2PMarketMapper p2PMarketMapper;

    @Override
    public Response<List<P2PMarketResponseDTO>> findByOwnerId(Long ownerId) {
        return Response.ok(
                p2PMarketRepository.findByOwnerId(ownerId).stream()
                        .map(p2PMarketMapper::toDTO)
                        .toList());
    }

    @Override
    public Response<List<P2PMarketResponseDTO>> findByCryptoType(CryptoType cryptoType) {
        return Response.ok(
                p2PMarketRepository.findByCryptoType(cryptoType).stream()
                        .map(p2PMarketMapper::toDTO)
                        .toList());
    }

    @Override
    public Response<P2PMarketResponseDTO> create(P2PMarketCreateDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> update(P2PMarketUpdateDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long id) {
        return null;
    }

    @Override
    public Response<P2PMarketResponseDTO> find(Long id) {
        return null;
    }

    @Override
    public Response<List<P2PMarketResponseDTO>> findAll() {
        return null;
    }
}
