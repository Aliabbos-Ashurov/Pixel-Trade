package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.P2POrderDTO;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.P2POrderStatus;
import com.pdp.PixelTrade.mapper.P2POrderMapper;
import com.pdp.PixelTrade.repository.P2POrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  16:14
 **/
@Service
@RequiredArgsConstructor
public class P2POrderService {
    private final P2POrderRepository p2POrderRepository;
    private final P2POrderMapper p2POrderMapper;

    public Response<List<P2POrderDTO>> findByCryptoType(@Param("cryptoType") CryptoType cryptoType) {
        return Response.ok(p2POrderRepository.findByCryptoType(cryptoType).stream()
                .map(p2POrderMapper::toDTO)
                .toList());
    }

    public Response<List<P2POrderDTO>> findByStatus(@Param("status") P2POrderStatus status) {
        return Response.ok(p2POrderRepository.findByStatus(status).stream()
                .map(p2POrderMapper::toDTO)
                .toList());
    }

    public Response<List<P2POrderDTO>> findByWalletId(@Param("walletId") Long walletId) {
        return Response.ok(p2POrderRepository.findByWalletId(walletId).stream()
                .map(p2POrderMapper::toDTO)
                .toList());
    }
}
