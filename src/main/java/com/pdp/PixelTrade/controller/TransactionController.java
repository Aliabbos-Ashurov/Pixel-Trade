package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.dto.request.transaction.TransactionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  12:18
 **/
@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @PostMapping("/transfer")
    public ResponseEntity<Void> transfer(@RequestBody TransactionDTO dto) {
        return ResponseEntity.noContent().build();
    }
}
