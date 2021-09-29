package com.codegym.repository.model.user;


public enum OrderStatus {
    DELAY("DELAY"), DESTROY("DESTROY"), RECEIVED("RECEIVED"),NEW("NEW"),PAYED("PAYED");
    private final String value;
    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static OrderStatus fromValue(String value) {
        OrderStatus[] status = values();
        for (OrderStatus c : status) {
            if (c.value.equalsIgnoreCase(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid account status value: " + value);
    }
}

