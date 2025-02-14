package org.example.utils;

import lombok.NonNull;

public final class TypeSpecifier {
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

    public static String getType(@NonNull String input) {
        if (TypeSpecifier.isInteger(input)) return "integer";
        else if (TypeSpecifier.isFloat(input)) return "float";
        else return "string";
    }

}
