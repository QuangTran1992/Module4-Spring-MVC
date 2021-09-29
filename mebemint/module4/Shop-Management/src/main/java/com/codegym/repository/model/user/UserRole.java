package com.codegym.repository.model.user;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {
    ADMIN("ADMIN"), SHIPPER("SHIPPER"), SHOP("SHOP");
    private final String value;
    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static UserRole fromValue(String value) {
        UserRole[] roles = values();
        for (UserRole c : roles) {
            if (c.value.equalsIgnoreCase(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid account status value: " + value);
    }
}
