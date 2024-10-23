package com.pdp.PixelTrade.eop.event;

import com.pdp.PixelTrade.eop.Event;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 23/October/2024  12:39
 **/
public record SendBackupMailEvent(
        @NotNull Long userId,
        @NotNull String mail
) implements Event {
}
