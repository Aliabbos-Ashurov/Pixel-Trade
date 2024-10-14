package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.request.transaction.CryptoCreateDTO;
import com.pdp.PixelTrade.service.CryptoService;
import com.pdp.PixelTrade.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  12:30
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/crypto")
@RequiredArgsConstructor
public class CryptoController {
    private final CryptoService cryptoService;

    public ResponseEntity<Void> cryptoCreate(@RequestBody CryptoCreateDTO dto) {
        cryptoService.save(dto);
        return ResponseEntity.noContent().build();
    }
}
