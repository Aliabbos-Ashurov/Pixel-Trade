package com.pdp.PixelTrade.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 10/October/2024  10:23
 **/
@Getter
@RequiredArgsConstructor
public enum NotificationEventType {

    ISSUE_REPORTED("ISSUE_REPORTED"),
    TRANSACTION_ALERT("TRANSACTION_ALERT"),
    REWARD_EARNED("REWARD_EARNED"),
    PASSWORD_RESET("PASSWORD_RESET"),
    NEW_MESSAGE("NEW_MESSAGE"),
    FRIEND_REQUEST("FRIEND_REQUEST"),
    SYSTEM_ALERT("SYSTEM_ALERT"),
    PROMOTIONAL_OFFER("PROMOTIONAL_OFFER"),
    ACCOUNT_VERIFICATION("ACCOUNT_VERIFICATION"),
    LOW_BALANCE_ALERT("LOW_BALANCE_ALERT"),
    FRIEND_JOINED("FRIEND_JOINED"),
    SETTINGS_UPDATED("SETTINGS_UPDATED");

    private final String value;
}
