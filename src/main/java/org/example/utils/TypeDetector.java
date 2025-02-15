package org.example.utils;

import lombok.NonNull;
import org.example.types.ValueType;

public final class TypeDetector {
    public static boolean isInteger(@NonNull String input) {
        try {
            Long.parseLong(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isFloat(@NonNull String input) {
        try {
            Double.parseDouble(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static ValueType getType(@NonNull String input) {
        if (isInteger(input)) return ValueType.INTEGER;
        else if (isFloat(input)) return ValueType.FLOAT;
        else return ValueType.STRING;
    }

}
