package com.models.enums;

import java.util.Arrays;

public enum BookType {

    PAPER_BOOK("paper_book"),
    E_BOOK("e_book"),
    AUDIO_BOOK("audio_book");

    private String stringValue;

    BookType(String stringValue){
        this.stringValue=stringValue;
    }

    public static BookType fromValue(String value) {
        for (BookType category : values()) {
            if (category.stringValue.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }

}
