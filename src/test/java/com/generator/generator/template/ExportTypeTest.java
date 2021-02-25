package com.generator.generator.template;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExportTypeTest {

    @Test
    @DisplayName("Tipo HTML está retornando extensão correta")
    void getEngineHtmlExtensionTest() {
        assertEquals("html", ExportType.HTML.getEngine().getExtension());
    }

    @Test
    @DisplayName("Tipo PDF está retornando extensão correta")
    void getEnginePdfExtensionTest() {
        assertEquals("pdf", ExportType.PDF.getEngine().getExtension());
    }

    @Test
    @DisplayName("Tipo TEXT está retornando extensão correta")
    void getEngineTextExtensionTest() {
        assertEquals("txt", ExportType.TEXT.getEngine().getExtension());
    }

    @Test
    @DisplayName("Nenhuma engine está nula")
    void engineIsNotNull() {
        for (var exportType : ExportType.values()) {
            assertNotNull(exportType.getEngine());
        }
    }
}
