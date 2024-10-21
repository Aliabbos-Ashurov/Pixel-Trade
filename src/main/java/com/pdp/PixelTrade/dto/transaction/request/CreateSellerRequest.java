package com.pdp.PixelTrade.dto.transaction.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pdp.PixelTrade.dto.marker.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Aliabbos Ashurov
 * @since 19/October/2024  13:05
 **/
@JsonPropertyOrder({"name", "bio", "profilePicture"})
public record CreateSellerRequest(
        @NotBlank @NotNull String name,
        @NotBlank @NotNull String bio,

        @JsonProperty("profile_picture")
        @NotNull MultipartFile profilePicture
) implements Request {
}
