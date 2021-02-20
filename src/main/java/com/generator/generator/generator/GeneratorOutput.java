package com.generator.generator.generator;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GeneratorOutput {

    private final String fileName;
    private final String blobType;
    private final Object file;
}
