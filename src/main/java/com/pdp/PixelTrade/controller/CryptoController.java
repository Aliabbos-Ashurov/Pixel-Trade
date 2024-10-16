package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.transaction.request.CryptoCreateDTO;
import com.pdp.PixelTrade.dto.transaction.response.CryptoResponseDTO;
import com.pdp.PixelTrade.service.CryptoService;
import com.pdp.PixelTrade.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  12:30
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/crypto")
@RequiredArgsConstructor
public class CryptoController {
    private final CryptoService cryptoService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> cryptoCreate(@Valid @ModelAttribute CryptoCreateDTO dto) {
        cryptoService.save(dto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponse<List<CryptoResponseDTO>>> cryptoList() {
        return ResponseEntity.ok(cryptoService.findAll());
    }
}
