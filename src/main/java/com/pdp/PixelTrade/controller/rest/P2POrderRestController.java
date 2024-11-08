package com.pdp.PixelTrade.controller.rest;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.P2POrderResponseDTO;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.P2POrderStatus;
import com.pdp.PixelTrade.service.P2POrderService;
import com.pdp.PixelTrade.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  16:35
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/p2p-order")
@RequiredArgsConstructor
public class P2POrderRestController {
    private final P2POrderService p2POrderService;

    @GetMapping("/get/by-wallet/{id}")
    public ResponseEntity<Response<List<P2POrderResponseDTO>>> getByWalletId(@PathVariable Long id) {
        return ResponseEntity.ok(p2POrderService.findByWalletId(id));
    }


    @GetMapping("/get/by-status/{status}")
    public ResponseEntity<Response<List<P2POrderResponseDTO>>> getByStatus(@PathVariable P2POrderStatus status) {
        return ResponseEntity.ok(p2POrderService.findByStatus(status));
    }

    @GetMapping("/get/by-crypto/{type}")
    public ResponseEntity<Response<List<P2POrderResponseDTO>>> getByCryptoType(@PathVariable CryptoType type) {
        return ResponseEntity.ok(p2POrderService.findByCryptoType(type));
    }
}
