package com.generator.generator.template;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface TemplateService {

    Page<TemplateEntity> findAllPageable(PageRequest pageRequest);

    TemplateEntity save(TemplateEntity templateEntity);

    Optional<TemplateEntity> findById(UUID templateId);
}
