package com.pdp.PixelTrade.eop.event;

import com.pdp.PixelTrade.eop.Event;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 23/October/2024  11:07
 **/
public record MailPasswordEvent(
        @NotBlank @NotNull String recipient
) implements Event {
}
