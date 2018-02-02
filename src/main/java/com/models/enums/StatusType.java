package com.models.enums;

import java.util.Arrays;

public enum StatusType {
    FREE("free"),
    BOOKED("booked");

    public String stringValue;

    StatusType(String stringValue){
        this.stringValue=stringValue;
    }

    public static StatusType fromValue(String value) {
        for (StatusType category : values()) {
            if (category.stringValue.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }

    public String getStringValue(){
        return this.stringValue;
    }
}