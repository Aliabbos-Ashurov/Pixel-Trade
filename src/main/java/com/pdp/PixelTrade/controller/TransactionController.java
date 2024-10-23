package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.request.TransactionCreateDTO;
import com.pdp.PixelTrade.dto.transaction.response.TransactionResponseDTO;
import com.pdp.PixelTrade.service.TransactionService;
import com.pdp.PixelTrade.service.TransferService;
import com.pdp.PixelTrade.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  12:18
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransferService transferService;
    private final TransactionService transactionService;

    @PostMapping(value = "/wallet-to-wallet",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<TransactionResponseDTO>> transfer(@Valid @RequestBody TransactionCreateDTO dto) {
        return ResponseEntity.ok(transferService.transferW2W(dto));
    }


    @GetMapping("/get/by-address/{address}")
    public ResponseEntity<Response<List<TransactionResponseDTO>>> getAll(@PathVariable String address) {
        return ResponseEntity.ok(transactionService.findAllByAddress(address));
    }
}
