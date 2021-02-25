package com.generator.generator.generator.engine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PdfGeneratorTest {

    @Test
    @DisplayName("generate passando valor null")
    void generateWithNullValueTest() {
        assertThrows(IllegalArgumentException.class, () -> new PdfGenerator().generate(null));
    }

    @Test
    @DisplayName("generate passando valor em branco")
    void generateWithBlankValueTest() {
        assertThrows(IllegalArgumentException.class, () -> new PdfGenerator().generate(""));
    }

}
