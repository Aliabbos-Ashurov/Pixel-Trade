package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.P2POrderResponseDTO;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.P2POrderStatus;
import com.pdp.PixelTrade.mapper.P2POrderMapper;
import com.pdp.PixelTrade.repository.P2POrderRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  16:14
 **/
@Service
public class P2POrderService extends AbstractService<P2POrderRepository, P2POrderMapper> {

    public P2POrderService(P2POrderRepository repository, P2POrderMapper mapper) {
        super(repository, mapper);
    }

    public Response<List<P2POrderResponseDTO>> findByCryptoType(@Param("cryptoType") CryptoType cryptoType) {
        return Response.ok(repository.findByCryptoType(cryptoType).stream()
                .map(mapper::toDTO)
                .toList());
    }

    public Response<List<P2POrderResponseDTO>> findByStatus(@Param("status") P2POrderStatus status) {
        return Response.ok(repository.findByStatus(status).stream()
                .map(mapper::toDTO)
                .toList());
    }

    public Response<List<P2POrderResponseDTO>> findByWalletId(@Param("walletId") Long walletId) {
        return Response.ok(repository.findByWalletId(walletId).stream()
                .map(mapper::toDTO)
                .toList());
    }
}
