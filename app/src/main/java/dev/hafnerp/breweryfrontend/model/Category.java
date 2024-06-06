package dev.hafnerp.breweryfrontend.model;

public enum Category {
    Larger,
    Bright,
    Dark,
    White,
    Light,
    Ale;

    public static Category fromString(String dayString) {
        for (Category day : Category.values()) {
            if (day.name().equalsIgnoreCase(dayString)) {
                return day;
            }
        }
        throw new IllegalArgumentException("Invalid category: " + dayString);
    }
}
