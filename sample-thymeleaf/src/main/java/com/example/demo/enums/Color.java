package com.example.demo.enums;

/**
 * @author sskim
 */
public enum Color {
    BLACK("Black"),
    BLUE("Blue"),
    RED("Red"),
    YELLOW("Yellow"),
    GREEN("Green"),
    ORANGE("Orange"),
    PURPLE("Purple"),
    WHITE("White");

    private final String displayValue;

    Color(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
