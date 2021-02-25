package com.generator.generator.generator.engine;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Slf4j
public class PdfGenerator implements GeneratorEngine {

    @Override
    public String getLabel() {
        return "PDF";
    }

    @Override
    public String getExtension() {
        return "pdf";
    }

    @Override
    public String getContentType() {
        return "application/pdf";
    }

    /**
     * Gera um PDF a partir de um HTML.
     * @param html {@link String} com o código html.
     * @return {@link String} com o PDF em formato base64.
     * @throws GeneratorException caso ocorra algum erro durante a geração do PDF.
     */
    @Override
    public Object generate(String html) throws GeneratorException {
        if (StringUtils.isBlank(html)) {
            throw new IllegalArgumentException("template gerado está vazio.");
        }

        try (var os = new ByteArrayOutputStream()) {
            new PdfRendererBuilder()
                    .toStream(os)
                    .withHtmlContent(html, null)
                    .run();

            log.info("PDF generation completed");
            return Base64.getEncoder().encodeToString(os.toByteArray());
        } catch (IOException e) {
            return null;
        }
    }
}
