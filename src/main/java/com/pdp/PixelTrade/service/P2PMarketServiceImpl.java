package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.request.P2PMarketCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.P2PMarketUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.P2PMarketResponseDTO;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.mapper.P2PMarketMapper;
import com.pdp.PixelTrade.repository.wallet.P2PMarketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:21
 **/
@Service
public class P2PMarketServiceImpl extends AbstractService<P2PMarketRepository, P2PMarketMapper> implements P2PMarketService {

    public P2PMarketServiceImpl(P2PMarketRepository repository, P2PMarketMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<List<P2PMarketResponseDTO>> findByOwnerId(Long ownerId) {
        return Response.ok(
                repository.findByOwnerId(ownerId).stream()
                        .map(mapper::toDTO)
                        .toList());
    }

    @Override
    public Response<List<P2PMarketResponseDTO>> findByCryptoType(CryptoType cryptoType) {
        return Response.ok(
                repository.findByCryptoType(cryptoType).stream()
                        .map(mapper::toDTO)
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
