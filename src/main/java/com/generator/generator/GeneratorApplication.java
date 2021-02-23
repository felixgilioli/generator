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
		this.saveTemplateContratoAluguel();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		this.saveTemplateContratoAluguel();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
		dkopsad();
	}

	private void dkopsad() {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName("Currículo");
		categoryEntity.setDescription("Modelo de Currículos.");
		categoryEntity = this.categoryService.save(categoryEntity);

		TemplateEntity templateEntity1 = new TemplateEntity();
		templateEntity1.setCategory(categoryEntity);
		templateEntity1.setTitle("Currículo Formal");
		templateEntity1.setDescription("Currículo em um formato mais formal.");
		templateEntity1.setImgLocation("https://binaries.templates.cdn.office.net/support/templates/pt-br/lw00002110_quantized.png");
		templateEntity1.setLocation("/templates/template01.html");
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
		inputEntity2.setPlaceholder("email@email.com");
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

	private void saveTemplateContratoAluguel() {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName("Contratos");
		categoryEntity.setDescription("Template com contratos sociais.");
		categoryEntity = categoryService.save(categoryEntity);

		TemplateEntity templateEntity = new TemplateEntity();
		templateEntity.setExportTypeSet(Set.of(ExportType.HTML, ExportType.PDF));
		templateEntity.setLocation("/templates/template-contrato-aluguel.html");
		templateEntity.setCategory(categoryEntity);
		templateEntity.setTitle("Contrato de aluguel");
		templateEntity.setDescription("Contrato de aluguel de imóvel com fiador e 2 testemunhas");
		templateEntity.setImgLocation("/img/contrato-aluguel.png");
		templateEntity = this.templateService.save(templateEntity);

		InputEntity input1 = new InputEntity();
		input1.setName("nomeLocador");
		input1.setLabel("Nome do Locador");
		input1.setType(InputType.TEXT);
		input1.setTemplate(templateEntity);
		input1.setOrdem(1);
		input1.setTitle(input1.getLabel());
		this.inputRepository.save(input1);

		InputEntity input2 = new InputEntity();
		input2.setName("cpfLocador");
		input2.setLabel("CPF do Locador");
		input2.setType(InputType.TEXT);
		input2.setTemplate(templateEntity);
		input2.setOrdem(2);
		input2.setTitle(input2.getLabel());
		this.inputRepository.save(input2);

		InputEntity input3 = new InputEntity();
		input3.setName("identidadeLocador");
		input3.setLabel("RG do Locador");
		input3.setOrdem(3);
		input3.setType(InputType.TEXT);
		input3.setTemplate(templateEntity);
		input3.setTitle(input3.getLabel());
		this.inputRepository.save(input3);

		InputEntity input4 = new InputEntity();
		input4.setName("enderecoLocador");
		input4.setLabel("Endereço do Locador");
		input4.setOrdem(4);
		input4.setType(InputType.TEXT);
		input4.setTemplate(templateEntity);
		input4.setTitle(input4.getLabel());
		this.inputRepository.save(input4);

		InputEntity input5 = new InputEntity();
		input5.setName("nomeLocatario");
		input5.setLabel("Nome do Locatário");
		input5.setOrdem(5);
		input5.setType(InputType.TEXT);
		input5.setTemplate(templateEntity);
		input5.setTitle(input5.getLabel());
		this.inputRepository.save(input5);

		InputEntity input6 = new InputEntity();
		input6.setName("cpfLocatario");
		input6.setLabel("CPF do Locatário");
		input6.setOrdem(6);
		input6.setType(InputType.TEXT);
		input6.setTemplate(templateEntity);
		input6.setTitle(input6.getLabel());
		this.inputRepository.save(input6);

		InputEntity input7 = new InputEntity();
		input7.setName("identidadeLocatario");
		input7.setLabel("RG do Locatário");
		input7.setOrdem(7);
		input7.setType(InputType.TEXT);
		input7.setTemplate(templateEntity);
		input7.setTitle(input7.getLabel());
		this.inputRepository.save(input7);

		InputEntity input8 = new InputEntity();
		input8.setName("enderecoLocatario");
		input8.setLabel("Endereço do Locatário");
		input8.setOrdem(8);
		input8.setType(InputType.TEXT);
		input8.setTemplate(templateEntity);
		input8.setTitle(input8.getLabel());
		this.inputRepository.save(input8);

		InputEntity input9 = new InputEntity();
		input9.setName("tempoLocacao");
		input9.setLabel("Tempo de locação");
		input9.setOrdem(9);
		input9.setType(InputType.NUMBER);
		input9.setTemplate(templateEntity);
		input9.setTitle(input9.getLabel());
		this.inputRepository.save(input9);

		InputEntity input10 = new InputEntity();
		input10.setName("dataInicioLocacao");
		input10.setLabel("Data de Início da locação");
		input10.setOrdem(10);
		input10.setType(InputType.TEXT);
		input10.setTemplate(templateEntity);
		input10.setTitle(input10.getLabel());
		this.inputRepository.save(input10);

		InputEntity input11 = new InputEntity();
		input11.setName("dataFimLocacao");
		input11.setLabel("Data de fim da locação");
		input11.setOrdem(11);
		input11.setType(InputType.TEXT);
		input11.setTemplate(templateEntity);
		input11.setTitle(input11.getLabel());
		this.inputRepository.save(input11);

		InputEntity input12 = new InputEntity();
		input12.setName("valorAluguel");
		input12.setLabel("Valor do aluguel");
		input12.setOrdem(12);
		input12.setType(InputType.NUMBER);
		input12.setTemplate(templateEntity);
		input12.setTitle(input12.getLabel());
		this.inputRepository.save(input12);

		InputEntity input13 = new InputEntity();
		input13.setName("nomeFiador");
		input13.setLabel("Nome do fiador");
		input13.setOrdem(13);
		input13.setType(InputType.TEXT);
		input13.setTemplate(templateEntity);
		input13.setTitle(input13.getLabel());
		this.inputRepository.save(input13);

		InputEntity input14 = new InputEntity();
		input14.setName("cpfFiador");
		input14.setLabel("CPF do fiador");
		input14.setOrdem(14);
		input14.setType(InputType.TEXT);
		input14.setTemplate(templateEntity);
		input14.setTitle(input14.getLabel());
		this.inputRepository.save(input14);

		InputEntity input15 = new InputEntity();
		input15.setName("identidadeFiador");
		input15.setLabel("RG do fiador");
		input15.setOrdem(15);
		input15.setType(InputType.TEXT);
		input15.setTemplate(templateEntity);
		input15.setTitle(input15.getLabel());
		this.inputRepository.save(input15);

		InputEntity input16 = new InputEntity();
		input16.setName("enderecoFiador");
		input16.setLabel("Endereço do fiador");
		input16.setOrdem(16);
		input16.setType(InputType.TEXT);
		input16.setTemplate(templateEntity);
		input16.setTitle(input16.getLabel());
		this.inputRepository.save(input16);

		InputEntity input17 = new InputEntity();
		input17.setName("nomeTestemunha1");
		input17.setLabel("Nome da primeira testemunha");
		input17.setOrdem(17);
		input17.setType(InputType.TEXT);
		input17.setTemplate(templateEntity);
		input17.setTitle(input17.getLabel());
		this.inputRepository.save(input17);

		InputEntity input18 = new InputEntity();
		input18.setName("identidadeTestemunha1");
		input18.setLabel("RG da primeira testemunha");
		input18.setOrdem(18);
		input18.setType(InputType.TEXT);
		input18.setTemplate(templateEntity);
		input18.setTitle(input18.getLabel());
		this.inputRepository.save(input18);

		InputEntity input19 = new InputEntity();
		input19.setName("nomeTestemunha2");
		input19.setLabel("Nome da segunda testemunha");
		input19.setOrdem(19);
		input19.setType(InputType.TEXT);
		input19.setTemplate(templateEntity);
		input19.setTitle(input19.getLabel());
		this.inputRepository.save(input19);

		InputEntity input20 = new InputEntity();
		input20.setName("identidadeTestemunha2");
		input20.setLabel("RG da segunda testemunha");
		input20.setOrdem(20);
		input20.setType(InputType.TEXT);
		input20.setTemplate(templateEntity);
		input20.setTitle(input20.getLabel());
		this.inputRepository.save(input20);

		InputEntity input21 = new InputEntity();
		input21.setName("diaPagamentoAluguel");
		input21.setLabel("Dia do pagamento do aluguel");
		input21.setOrdem(21);
		input21.setType(InputType.NUMBER);
		input21.setTemplate(templateEntity);
		input21.setTitle(input21.getLabel());
		this.inputRepository.save(input21);
	}

}
