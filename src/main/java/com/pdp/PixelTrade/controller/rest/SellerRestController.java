package com.pdp.PixelTrade.controller.rest;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.SellerResponseDTO;
import com.pdp.PixelTrade.service.SellerService;
import com.pdp.PixelTrade.utils.Constants;
import jakarta.validation.constraints.NotBlank;
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
 * @since 19/October/2024  13:20
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/seller")
@RequiredArgsConstructor
public class SellerRestController {
    private final SellerService sellerService;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<SellerResponseDTO>>> findAllSeller() {
        return ResponseEntity.ok(sellerService.findAll());
    }

    @GetMapping(value = "/get/by-name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<SellerResponseDTO>> findByName(@NotBlank @PathVariable String name) {
        return ResponseEntity.ok(sellerService.findByName(name));
    }
}
