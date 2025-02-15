package org.example;

import org.example.utils.TypeDetector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TypeDetectorTest {

    @Test
    void isFloatTest() {
        assertTrue(TypeDetector.isFloat("24"), "24 должно быть распознано как число с плавающей запятой");
        assertFalse(TypeDetector.isFloat("24 years"), "24 years не является числом с плавающей запятой");
        assertFalse(TypeDetector.isFloat("Годы идут 192"), "Годы идут 192 не является числом с плавающей запятой");
        assertTrue(TypeDetector.isFloat(" 17 "), " 17 должно быть распознано как число с плавающей запятой");
        assertTrue(TypeDetector.isFloat("14.5"), "14.5 должно быть распознано как число с плавающей запятой");
        assertTrue(TypeDetector.isFloat("-24"), "-24 должно быть распознано как число с плавающей запятой");
        assertFalse(TypeDetector.isFloat(" 24 years "), " 24 years не является числом с плавающей запятой");
        assertTrue(TypeDetector.isFloat(" 1.528535047E-25 "), "1.528535047E-25 должно быть распознано как число с плавающей запятой");
    }

    @Test
    void isIntegerTest() {
        assertTrue(TypeDetector.isInteger("24"), "24 должно быть распознано как целое число");
        assertFalse(TypeDetector.isInteger("24 years"), "24 years не является целым числом");
        assertFalse(TypeDetector.isInteger("Годы идут 192"), "Годы идут 192 не является целым числом");
        assertTrue(TypeDetector.isInteger(" 17 "), " 17 должно быть распознано как целое число");
        assertFalse(TypeDetector.isInteger("14.5"), "14.5 не является целым числом");
        assertTrue(TypeDetector.isInteger("-24"), "-24 должно быть распознано как целое число");
        assertFalse(TypeDetector.isInteger(" 24 years "), " 24 years не является целым числом");
        assertTrue(TypeDetector.isInteger(" 1234567890123456789 "), "1234567890123456789 должно быть распознано как целое число");
    }
}