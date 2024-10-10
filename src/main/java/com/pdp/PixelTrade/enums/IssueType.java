package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  10:28
 **/
@Getter
@RequiredArgsConstructor
public enum IssueType {

    BUG("BUG"),
    ACCOUNT_PROBLEM("ACCOUNT_PROBLEM"),
    SUGGESTION("SUGGESTION"),
    FEATURE_REQUEST("FEATURE_REQUEST"),
    PERFORMANCE_ISSUE("PERFORMANCE_ISSUE");

    private final String value;

}
