package com.generator.generator;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.generator.generator.category.CategoryEntity;
import com.generator.generator.category.CategoryService;
import com.generator.generator.input.InputEntity;
import com.generator.generator.input.InputRepository;
import com.generator.generator.input.InputType;
import com.generator.generator.template.ExportType;
import com.generator.generator.template.TemplateEntity;
import com.generator.generator.template.TemplateService;

@SpringBootApplication
public class GeneratorApplication {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private TemplateService templateService;

	@Autowired
	private InputRepository inputRepository;

	public static void main(String[] args) {
		SpringApplication.run(GeneratorApplication.class, args);
	}

	@PostConstruct
	public void init() {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName("Currículo");
		categoryEntity.setDescription("Modelo de Currículos.");
		categoryEntity = this.categoryService.save(categoryEntity);

		TemplateEntity templateEntity1 = new TemplateEntity();
		templateEntity1.setCategory(categoryEntity);
		templateEntity1.setTitle("Currículo Formal");
		templateEntity1.setDescription("Currículo em um formato mais formal.");
		templateEntity1.setImgLocation("https://binaries.templates.cdn.office.net/support/templates/pt-br/lw00002110_quantized.png");
		templateEntity1.setLocation("/templates/template01.ftl");
		templateEntity1.setExportTypeSet(Set.of(ExportType.TEXT, ExportType.HTML, ExportType.PDF));
		templateEntity1 = this.templateService.save(templateEntity1);

		TemplateEntity templateEntity2 = new TemplateEntity();
		templateEntity2.setCategory(categoryEntity);
		templateEntity2.setTitle("Currículo Simples");
		templateEntity2.setDescription("Currículo simplificado.");
		templateEntity2.setImgLocation("https://www.pravaler.com.br/wp-content/uploads/2020/07/modelo-de-curriculo-profissoes-fisioterapia.jpg");
		templateEntity2.setLocation("/templates/template02.ftl");
		templateEntity2 = this.templateService.save(templateEntity2);

		TemplateEntity templateEntity3 = new TemplateEntity();
		templateEntity3.setCategory(categoryEntity);
		templateEntity3.setTitle("Currículo Jovem Aprendiz");
		templateEntity3.setDescription("Currículo de jovem aprendiz");
		templateEntity3.setImgLocation("https://themosvagas.com.br/wp-content/uploads/2020/01/Jovem-Aprendiz-Timon.jpg");
		templateEntity3.setLocation("/templates/template03.ftl");
		templateEntity3 = this.templateService.save(templateEntity3);

		InputEntity inputEntity1 = new InputEntity();
		inputEntity1.setLabel("Nome:");
		inputEntity1.setName("nome");
		inputEntity1.setTemplate(templateEntity1);
		inputEntity1.setType(InputType.TEXT);
		inputEntity1.setOrdem(1);
		this.inputRepository.save(inputEntity1);

		InputEntity inputEntity2 = new InputEntity();
		inputEntity2.setLabel("Email:");
		inputEntity2.setName("email");
		inputEntity2.setTemplate(templateEntity1);
		inputEntity2.setType(InputType.EMAIL);
		inputEntity2.setOrdem(2);
		this.inputRepository.save(inputEntity2);

		InputEntity inputEntity3 = new InputEntity();
		inputEntity3.setLabel("Sobre você:");
		inputEntity3.setName("sobre");
		inputEntity3.setTemplate(templateEntity1);
		inputEntity3.setType(InputType.TEXTAREA);
		inputEntity3.setOrdem(3);
		this.inputRepository.save(inputEntity3);

	}

}
