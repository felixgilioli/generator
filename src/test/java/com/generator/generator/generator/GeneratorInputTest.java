package com.generator.generator.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorInputTest {

    @Test
    @DisplayName("getParams quando params for null")
    void getParamsWithNull() {
        GeneratorInput generatorInput = new GeneratorInput();
        generatorInput.setParams(null);
        assertNull(generatorInput.getParams());
    }

    @Test
    @DisplayName("getParams quando params for vazio")
    void getParamsWithEmptyParams() {
        GeneratorInput generatorInput = new GeneratorInput();
        generatorInput.setParams(new HashMap<>());
        assertTrue(generatorInput.getParams().isEmpty());
    }

    @Test
    @DisplayName("getParams quando params tiver valor null")
    void getParamsWithNullValuesInMap() {
        GeneratorInput generatorInput = new GeneratorInput();
        Map<String, Object> map = new HashMap<>();
        map.put("test1", "dasdsa");
        map.put("test2", null);
        generatorInput.setParams(map);
        assertEquals("", generatorInput.getParams().get("test2"));
    }

    @Test
    @DisplayName("getParams quando params nao tiver valor null")
    void getParamsWithoutNullValuesInMap() {
        GeneratorInput generatorInput = new GeneratorInput();
        Map<String, Object> map = new HashMap<>();
        map.put("test1", "dasdsa");
        map.put("test2", "felix");
        generatorInput.setParams(map);
        assertEquals("felix", generatorInput.getParams().get("test2"));
    }

}
