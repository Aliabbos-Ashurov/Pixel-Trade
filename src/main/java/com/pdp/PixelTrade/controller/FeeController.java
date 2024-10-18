package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.Fee;
import com.pdp.PixelTrade.service.wallet.FeeService;
import com.pdp.PixelTrade.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 16/October/2024  16:11
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/fee")
@RequiredArgsConstructor
public class FeeController {
    private final FeeService feeService;

    @GetMapping("/get")
    public ResponseEntity<ApiResponse<List<Fee>>> fees() {
        return ResponseEntity.ok(feeService.findActiveTransactionFees());
    }
}
