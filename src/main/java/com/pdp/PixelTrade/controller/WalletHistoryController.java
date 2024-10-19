package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.transaction.response.WalletHistoryDTO;
import com.pdp.PixelTrade.service.wallet.WalletHistoryService;
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
public class WalletHistoryController {

    private final WalletHistoryService walletHistoryService;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<WalletHistoryDTO>>> findAll() {
        return ResponseEntity.ok(walletHistoryService.findAll());
    }

    @GetMapping(value = "/get/by-wallet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<WalletHistoryDTO>>> findWalletId(@PathVariable Long id) {
        return ResponseEntity.ok(walletHistoryService.findByWalletId(id));
    }

    @GetMapping(value = "/get/by-address/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<WalletHistoryDTO>>> findByAddress(@PathVariable String address) {
        return ResponseEntity.ok(walletHistoryService.findByWalletAddress(address));
    }

}
