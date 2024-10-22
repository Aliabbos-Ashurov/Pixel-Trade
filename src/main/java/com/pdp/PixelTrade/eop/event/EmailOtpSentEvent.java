package com.pdp.PixelTrade.eop.event;

import com.pdp.PixelTrade.eop.Event;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 06/October/2024  14:58
 **/
public record EmailOtpSentEvent(@NotNull String recipient) implements Event {
}
