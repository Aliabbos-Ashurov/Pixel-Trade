package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  10:37
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/notification")
@RequiredArgsConstructor
public class NotificationController {

    @SneakyThrows
    @PostMapping("/send")
    public ResponseEntity<Void> send(@RequestParam String recipient) {
        return ResponseEntity.noContent().build();
    }
}
