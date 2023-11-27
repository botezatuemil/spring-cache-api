package com.example.simplecacheapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Categories {
    SF( "SF"),

    NON_SF("NON_SF");

    private String value;
    Categories(String value) {this.value = value;}

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static Categories fromValue(String text) {
        for (Categories c: Categories.values()) {
            if (String.valueOf(c.value).equals(text)) {
                return c;
            }
        }
        return null;
    }


}
