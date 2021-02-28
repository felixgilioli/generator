package com.generator.generator;

import com.generator.generator.entityfactory.category.CategoryFactory;
import com.generator.generator.entityfactory.template.TemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class GeneratorApplication {

	@Autowired
	private List<CategoryFactory> categoryFactoryList;

	@Autowired
	private List<TemplateFactory> templateFactoryList;

	public static void main(String[] args) {
		SpringApplication.run(GeneratorApplication.class, args);
	}

	@PostConstruct
	public void init() {
		this.categoryFactoryList.forEach(CategoryFactory::create);
		this.templateFactoryList.forEach(TemplateFactory::create);
	}

}
