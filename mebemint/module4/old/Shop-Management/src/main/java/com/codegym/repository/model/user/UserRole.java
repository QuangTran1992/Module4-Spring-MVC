package com.codegym.repository.model.user;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {
    ADMIN("ADMIN"), SHIPPER("SHIPPER"), SHOP("SHOP");
    private String value;
    private UserRole(String value) {
        this.value = value;
    }
    @JsonValue
    public String getValue() {
        return this.value;
    }
    @JsonCreator
    public static UserRole fromValue(String value) {
        UserRole[] var1 = values();
        int var2 = var1.length;
        for (int var3 = 0; var3 < var2; ++var3) {
            UserRole c = var1[var3];
            if (c.value.equalsIgnoreCase(value) ) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid account status value: " + value);
    }
}
