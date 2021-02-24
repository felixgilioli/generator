package com.generator.generator.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BooleanNotNullConverterTest {

    @Test
    @DisplayName("convertToDatabaseColumn com boolean null deve retornar false")
    void convertToDatabaseColumnWithNullValueTest() {
        var converter = new BooleanNotNullConverter();
        assertFalse(converter.convertToDatabaseColumn(null));
    }

    @Test
    @DisplayName("convertToDatabaseColumn com boolean false deve retornar false")
    void convertToDatabaseColumnWithFalseValueTest() {
        var converter = new BooleanNotNullConverter();
        assertFalse(converter.convertToDatabaseColumn(false));
    }

    @Test
    @DisplayName("convertToDatabaseColumn com boolean true deve retornar true")
    void convertToDatabaseColumnWithTrueValueTest() {
        var converter = new BooleanNotNullConverter();
        assertTrue(converter.convertToDatabaseColumn(true));
    }

    @Test
    @DisplayName("convertToEntityAttribute com boolean null deve retornar null")
    void convertToEntityAttributeWithNullValue() {
        var converter = new BooleanNotNullConverter();
        assertNull(converter.convertToEntityAttribute(null));
    }

    @Test
    @DisplayName("convertToEntityAttribute com boolean false deve retornar false")
    void convertToEntityAttributeWithFalseValue() {
        var converter = new BooleanNotNullConverter();
        assertFalse(converter.convertToEntityAttribute(false));
    }

    @Test
    @DisplayName("convertToEntityAttribute com boolean true deve retornar true")
    void convertToEntityAttributeWithTrueValue() {
        var converter = new BooleanNotNullConverter();
        assertTrue(converter.convertToEntityAttribute(true));
    }
}
