package com.generator.generator.generator;

import java.io.StringWriter;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generator.generator.template.TemplateService;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private Configuration freemarkerConfiguration;

    @Autowired
    private TemplateService templateService;

    @Override
    public String generate(GeneratorDTO generatorDTO) {
        try {
            final Optional<String> templateLocation = this.templateService.findLocationByTemplateId(UUID.fromString(generatorDTO.getTemplateId()));

            if (templateLocation.isEmpty()) {
                throw new IllegalArgumentException("templateId is invalid: " + generatorDTO.getTemplateId());
            }

            final Template template = this.freemarkerConfiguration.getTemplate(templateLocation.get());
            final StringWriter stringWriter = new StringWriter();
            template.process(generatorDTO.getParams(), stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
