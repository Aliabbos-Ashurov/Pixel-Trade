package com.pdp.PixelTrade.controller.rest;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.WalletHistoryResponseDTO;
import com.pdp.PixelTrade.service.WalletHistoryService;
import com.pdp.PixelTrade.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 18/October/2024  17:39
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/history")
@RequiredArgsConstructor
public class WalletHistoryRestController {

    private final WalletHistoryService walletHistoryService;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<WalletHistoryResponseDTO>>> findAll() {
        return ResponseEntity.ok(walletHistoryService.findAll());
    }

    @GetMapping(value = "/get/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<WalletHistoryResponseDTO>>> getMe() {
        return ResponseEntity.ok(walletHistoryService.getMe());
    }

    @GetMapping(value = "/get/by-wallet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<WalletHistoryResponseDTO>>> findWalletId(@PathVariable Long id) {
        return ResponseEntity.ok(walletHistoryService.findByWalletId(id));
    }

    @GetMapping(value = "/get/by-address/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<WalletHistoryResponseDTO>>> findByAddress(@PathVariable String address) {
        return ResponseEntity.ok(walletHistoryService.findByWalletAddress(address));
    }

}
