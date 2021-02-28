package com.generator.generator.entityfactory.category;

import com.generator.generator.category.CategoryEntity;
import com.generator.generator.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractCategoryFactory implements CategoryFactory {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void create() {
        var categoryEntity = new CategoryEntity();
        categoryEntity.setName("Contrato");
        categoryEntity.setDescription("Documento referente a um contrato");
        this.categoryRepository.save(categoryEntity);
    }
}
