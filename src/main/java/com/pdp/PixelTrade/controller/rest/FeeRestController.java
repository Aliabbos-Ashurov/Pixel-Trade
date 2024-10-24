package com.pdp.PixelTrade.controller.rest;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.entity.wallet.Fee;
import com.pdp.PixelTrade.service.FeeService;
import com.pdp.PixelTrade.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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
public class FeeRestController {
    private final FeeService feeService;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<Fee>>> fees() {
        return ResponseEntity.ok(feeService.findActiveTransactionFees());
    }
}
