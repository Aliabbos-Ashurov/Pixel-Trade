package com.pdp.PixelTrade.controller.graph;

import com.pdp.PixelTrade.dto.auth.UserResponseDTO;
import com.pdp.PixelTrade.dto.auth.UserUpdateDTO;
import com.pdp.PixelTrade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * @author Aliabbos Ashurov
 * @since 24/October/2024  14:34
 **/
@Controller
@RequiredArgsConstructor
public class UserGraphQLController {

    private final UserService userService;

    @QueryMapping(value = "profile")
    public UserResponseDTO getMe() {
        return userService.findMe().getData();
    }

    @QueryMapping(value = "existMail")
    public Boolean existMail(@Argument String mail) {
        return userService.existEmail(mail).getData();
    }

    @MutationMapping(value = "updatePassword")
    public Boolean updatePassword(@Argument(value = "dto") UserUpdateDTO dto) {
        return userService.update(dto).getData();
    }
}
