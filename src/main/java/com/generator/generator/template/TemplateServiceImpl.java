package com.generator.generator.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<TemplateEntity> findAllPageable(PageRequest pageRequest) {
        return this.templateRepository.findAll(pageRequest);
    }

    @Override
    public TemplateEntity save(TemplateEntity templateEntity) {
        return this.templateRepository.save(templateEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TemplateEntity> findById(UUID templateId) {
        final Optional<TemplateEntity> templateEntity = this.templateRepository.findById(templateId);
        templateEntity.map(TemplateEntity::getInputGroupList).ifPresent(List::size);
        return templateEntity;
    }
}
