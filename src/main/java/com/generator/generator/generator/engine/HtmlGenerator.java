package com.generator.generator.generator.engine;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class HtmlGenerator implements GeneratorEngine {

    @Override
    public String getLabel() {
        return "HTML";
    }

    @Override
    public String getExtension() {
        return "html";
    }

    @Override
    public String getContentType() {
        return "text/html";
    }

    /**
     * Retorna um HTML a partir do template.
     * @param html template com valores informados.
     * @return {@link String} com html.
     * @throws GeneratorException caso ocorra algum erro durante a geração do PDF.
     */
    @Override
    public Object generate(String html) throws GeneratorException {
        if (StringUtils.isBlank(html)) {
            throw new IllegalArgumentException("template gerado está vazio.");
        }

        log.info("HTML generation completed");
        return html;
    }
}
