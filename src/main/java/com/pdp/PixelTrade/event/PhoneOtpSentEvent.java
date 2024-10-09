package com.pdp.PixelTrade.event;

import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 09/October/2024  09:48
 **/
public record PhoneOtpSentEvent(@NotNull String recipient) implements Event {
}
