package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {
    CUSTOMER(1),
    EMPLOYEE(2);

    private final int value;

    UserType(int value) {
        this.value = value;
    }
    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static UserType fromValue(int value) {
        for (UserType type : UserType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid UserType value: " + value);
    }
}
