package com.generator.generator.generator;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratorDTO {

    private String templateId;
    private Map<String, Object> params;

}
