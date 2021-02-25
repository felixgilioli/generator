package com.generator.generator.generator.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextGeneratorTest {

    @Test
    @DisplayName("generate passando valor null")
    void generateWithNullValueTest() {
        assertThrows(IllegalArgumentException.class, () -> new TextGenerator().generate(null));
    }

    @Test
    @DisplayName("generate passando valor em branco")
    void generateWithBlankValueTest() {
        assertThrows(IllegalArgumentException.class, () -> new TextGenerator().generate(""));
    }

    @Test
    @DisplayName("generate passando template deve retornar ele mesmo")
    void generateTest() {
        String html = "<h1>oi</h1>";
        try {
            assertSame(html, new TextGenerator().generate(html));
        } catch (GeneratorException e) {
            Assertions.fail();
        }
    }
}
