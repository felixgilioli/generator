package com.generator.generator.generator;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generator.generator.template.TemplateEntity;
import com.generator.generator.template.TemplateService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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
            final Template template = this.freemarkerConfiguration.getTemplate(templateEntity.get().getLocation());
            template.process(generatorInput.getParams(), stringWriter);

            return GeneratorOutput.builder()
                    .fileName(templateEntity.get().getTitle() + "." + generatorInput.getType().getExtension())
                    .blobType(generatorInput.getType().getBlobType())
                    .file(stringWriter.toString())
                    .build();
        } catch (TemplateException | IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
