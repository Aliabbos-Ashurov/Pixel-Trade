package com.pdp.PixelTrade.eop.event;

import com.pdp.PixelTrade.eop.Event;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 09/October/2024  09:48
 **/
public record PhoneOtpSentEvent(@NotNull String recipient) implements Event {
}
