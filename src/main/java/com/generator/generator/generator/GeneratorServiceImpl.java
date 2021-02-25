package com.generator.generator.generator;

import com.generator.generator.generator.engine.GeneratorException;
import com.generator.generator.template.TemplateEntity;
import com.generator.generator.template.TemplateService;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Optional;
import java.util.UUID;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private Configuration freemarkerConfiguration;

    @Autowired
    private TemplateService templateService;

    @Override
    public GeneratorOutput generate(GeneratorInput generatorInput) {
        final Optional<TemplateEntity> templateEntity = this.templateService.findById(UUID.fromString(generatorInput.getTemplateId()));

        if (templateEntity.isEmpty()) {
            throw new IllegalArgumentException("templateId is invalid: " + generatorInput.getTemplateId());
        }

        try (StringWriter stringWriter = new StringWriter()) {
            final var template = this.freemarkerConfiguration.getTemplate(templateEntity.get().getLocation());
            template.process(generatorInput.getParams(), stringWriter);

            final var generatorEngine = generatorInput.getType().getEngine();
            return GeneratorOutput.builder()
                    .fileName(templateEntity.get().getTitle() + "." + generatorEngine.getExtension())
                    .blobType(generatorEngine.getContentType())
                    .file(generatorEngine.generate(stringWriter.toString()))
                    .build();
        } catch (TemplateException e) {
            throw new RuntimeException("Template apresenta problemas. " + templateEntity.get().getId());
        } catch (GeneratorException | IOException e) {
            throw new RuntimeException("Erro ao gerar documento.");
        }
    }
}
