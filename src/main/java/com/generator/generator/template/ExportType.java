package com.generator.generator.template;

import com.generator.generator.generator.engine.GeneratorEngine;
import com.generator.generator.generator.engine.HtmlGenerator;
import com.generator.generator.generator.engine.PdfGenerator;
import com.generator.generator.generator.engine.TextGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExportType {
    HTML(new HtmlGenerator()),
    TEXT(new TextGenerator()),
    PDF(new PdfGenerator());

    @Getter
    private final GeneratorEngine engine;

}
