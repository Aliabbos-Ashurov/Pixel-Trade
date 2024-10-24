package com.pdp.PixelTrade.controller.rest;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.UserResponseDTO;
import com.pdp.PixelTrade.dto.auth.UserUpdateDTO;
import com.pdp.PixelTrade.service.UserService;
import com.pdp.PixelTrade.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:16
 **/
@RestController
@RequestMapping(Constants.BASE_PATH_V1 + "/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping(value = "/profile/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<UserResponseDTO>> profile() {
        return ResponseEntity.ok(userService.findMe());
    }

    @PutMapping(value = "/update/password")
    public ResponseEntity<Void> updatePassword(@Valid @RequestBody UserUpdateDTO dto) {
        userService.update(dto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exist-mail/{mail}")
    public ResponseEntity<Response<Boolean>> existMail(@PathVariable String mail) {
        return ResponseEntity.ok(userService.existEmail(mail));
    }
}
