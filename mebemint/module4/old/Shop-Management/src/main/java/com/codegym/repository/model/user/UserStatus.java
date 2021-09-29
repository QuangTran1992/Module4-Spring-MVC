package com.codegym.repository.model.user;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
public enum UserStatus {
    ACTIVATED(0), LOCKED(1), UNACTIVATED(2), MAIL_CHANGED(3);
    private int value;
    private UserStatus(int value) {
        this.value = value;
    }
    @JsonValue
    public int getValue() {
        return this.value;
    }
    @JsonCreator
    public static UserStatus fromValue(int value) {
        UserStatus[] var1 = values();
        int var2 = var1.length;
        for (int var3 = 0; var3 < var2; ++var3) {
            UserStatus c = var1[var3];
            if (c.value == value) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid account status value: " + value);
    }
}
