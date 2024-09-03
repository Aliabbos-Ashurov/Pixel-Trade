package com.pdp.PixelTrade.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ExceptionUtils {

    /**
     * Converts the stack trace of an exception to a string if in debug mode.
     * Otherwise, returns a generic support message.
     *
     * @param ex        the exception
     * @param debugMode flag indicating whether debug mode is enabled
     * @return the stack trace as a string or a support message
     */
    public static String getExceptionDetails(Exception ex, boolean debugMode) {
        if (debugMode) {
            return Arrays.stream(ex.getStackTrace())
                    .map(StackTraceElement::toString)
                    .collect(Collectors.joining("\n"));
        } else {
            return "Contact support for more details.";
        }
    }
}
