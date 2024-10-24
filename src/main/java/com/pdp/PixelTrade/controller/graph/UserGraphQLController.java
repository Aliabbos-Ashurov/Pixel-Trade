package com.pdp.PixelTrade.controller.graph;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.UserResponseDTO;
import com.pdp.PixelTrade.service.UserService;
import lombok.RequiredArgsConstructor;
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

    @QueryMapping(name = "profile")
    public Response<UserResponseDTO> getMe() {
        return userService.findMe();
    }
}
