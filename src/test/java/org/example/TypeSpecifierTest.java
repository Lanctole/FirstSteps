package org.example;

import org.example.utils.TypeSpecifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TypeSpecifierTest {

    @Test
    void isFloatTest() {
        assertTrue(TypeSpecifier.isFloat("24"), "24 должно быть распознано как число с плавающей запятой");
        assertFalse(TypeSpecifier.isFloat("24 years"), "24 years не является числом с плавающей запятой");
        assertFalse(TypeSpecifier.isFloat("Годы идут 192"), "Годы идут 192 не является числом с плавающей запятой");
        assertTrue(TypeSpecifier.isFloat(" 17 "), " 17 должно быть распознано как число с плавающей запятой");
        assertTrue(TypeSpecifier.isFloat("14.5"), "14.5 должно быть распознано как число с плавающей запятой");
        assertTrue(TypeSpecifier.isFloat("-24"), "-24 должно быть распознано как число с плавающей запятой");
        assertFalse(TypeSpecifier.isFloat(" 24 years "), " 24 years не является числом с плавающей запятой");
        assertTrue(TypeSpecifier.isFloat(" 1.528535047E-25 "), "1.528535047E-25 должно быть распознано как число с плавающей запятой");
    }

    @Test
    void isIntegerTest() {
        assertTrue(TypeSpecifier.isInteger("24"), "24 должно быть распознано как целое число");
        assertFalse(TypeSpecifier.isInteger("24 years"), "24 years не является целым числом");
        assertFalse(TypeSpecifier.isInteger("Годы идут 192"), "Годы идут 192 не является целым числом");
        assertTrue(TypeSpecifier.isInteger(" 17 "), " 17 должно быть распознано как целое число");
        assertFalse(TypeSpecifier.isInteger("14.5"), "14.5 не является целым числом");
        assertTrue(TypeSpecifier.isInteger("-24"), "-24 должно быть распознано как целое число");
        assertFalse(TypeSpecifier.isInteger(" 24 years "), " 24 years не является целым числом");
        assertTrue(TypeSpecifier.isInteger(" 1234567890123456789 "), "1234567890123456789 должно быть распознано как целое число");
    }
}