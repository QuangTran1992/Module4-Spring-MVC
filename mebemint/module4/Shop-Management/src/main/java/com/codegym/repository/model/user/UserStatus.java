package com.codegym.repository.model.user;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
public enum UserStatus {
    ACTIVATED(0), LOCKED(1), UNACTIVATED(2), MAIL_CHANGED(3);
    private final int value;
    UserStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static UserStatus fromValue(int value) {
        UserStatus[] values = values();
        for (UserStatus c : values) {
            if (c.value == value) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid account status value: " + value);
    }
}
