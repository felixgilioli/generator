package com.generator.generator.generator.engine;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class TextGenerator implements GeneratorEngine {

    @Override
    public String getLabel() {
        return "Texto";
    }

    @Override
    public String getExtension() {
        return "txt";
    }

    @Override
    public String getContentType() {
        return "text/plain";
    }

    /**
     * Retorna um TXT a partir do template.
     * @param templateInput template com valores informados.
     * @return {@link String} com texto.
     * @throws GeneratorException caso ocorra algum erro durante a geração do PDF.
     */
    @Override
    public Object generate(String templateInput) throws GeneratorException {
        if (StringUtils.isBlank(templateInput)) {
            throw new IllegalArgumentException("template gerado está vazio.");
        }

        log.info("TXT generation completed");
        return templateInput;
    }
}
