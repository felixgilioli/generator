package com.generator.generator;

import com.generator.generator.category.CategoryEntity;
import com.generator.generator.category.CategoryService;
import com.generator.generator.input.InputEntity;
import com.generator.generator.input.InputRepository;
import com.generator.generator.input.InputType;
import com.generator.generator.inputgroup.InputGroupEntity;
import com.generator.generator.inputgroup.InputGroupRepository;
import com.generator.generator.template.ExportType;
import com.generator.generator.template.TemplateEntity;
import com.generator.generator.template.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class GeneratorApplication {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private TemplateService templateService;

	@Autowired
	private InputGroupRepository inputGroupRepository;

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
		inputEntity1.setType(InputType.TEXT);
		inputEntity1.setOrdem(1);

		InputEntity inputEntity2 = new InputEntity();
		inputEntity2.setLabel("Email:");
		inputEntity2.setName("email");
		inputEntity2.setPlaceholder("email@email.com");
		inputEntity2.setType(InputType.EMAIL);
		inputEntity2.setOrdem(2);

		InputEntity inputEntity3 = new InputEntity();
		inputEntity3.setLabel("Sobre você:");
		inputEntity3.setName("sobre");
		inputEntity3.setType(InputType.TEXTAREA);
		inputEntity3.setOrdem(3);

		InputGroupEntity inputGroupEntity1 = new InputGroupEntity();
		inputGroupEntity1.setOrdem(1);
		inputGroupEntity1.setTemplate(templateEntity1);
		inputGroupEntity1.setLegend("dasdsa do dasdas");
		inputGroupEntity1.setInputList(List.of(inputEntity1, inputEntity2, inputEntity3));
		inputGroupEntity1.getInputList().forEach(i -> i.setInputGroup(inputGroupEntity1));
		inputGroupRepository.save(inputGroupEntity1);
	}

	private void saveTemplateContratoAluguel() {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName("Contratos");
		categoryEntity.setDescription("Template com contratos sociais.");
		categoryEntity = categoryService.save(categoryEntity);

		TemplateEntity templateEntity = new TemplateEntity();
		templateEntity.setExportTypeSet(Set.of(ExportType.HTML, ExportType.PDF));
		templateEntity.setLocation("/templates/template-contrato-aluguel.ftl");
		templateEntity.setCategory(categoryEntity);
		templateEntity.setTitle("Contrato de aluguel");
		templateEntity.setDescription("Contrato de aluguel de imóvel com fiador e 2 testemunhas");
		templateEntity.setImgLocation("/img/contrato-aluguel.png");
		templateEntity = this.templateService.save(templateEntity);

		InputEntity input1 = new InputEntity();
		input1.setName("nomeLocador");
		input1.setLabel("Nome do Locador");
		input1.setType(InputType.TEXT);
		input1.setOrdem(1);
		input1.setTitle(input1.getLabel());
		input1.setRequired(true);

		InputEntity input2 = new InputEntity();
		input2.setName("cpfLocador");
		input2.setLabel("CPF do Locador");
		input2.setType(InputType.MASK);
		input2.setMask("000.000.000-00");
		input2.setOrdem(2);
		input2.setTitle(input2.getLabel());
		input2.setRequired(true);

		InputEntity input3 = new InputEntity();
		input3.setName("identidadeLocador");
		input3.setLabel("RG do Locador");
		input3.setMask("00.000.000-0");
		input3.setOrdem(3);
		input3.setType(InputType.MASK);
		input3.setTitle(input3.getLabel());
		input3.setRequired(true);

		InputEntity input4 = new InputEntity();
		input4.setName("enderecoLocador");
		input4.setLabel("Endereço do Locador");
		input4.setOrdem(4);
		input4.setType(InputType.TEXT);
		input4.setTitle(input4.getLabel());
		input4.setRequired(true);

		InputGroupEntity inputGroupEntity1 = new InputGroupEntity();
		inputGroupEntity1.setOrdem(1);
		inputGroupEntity1.setTemplate(templateEntity);
		inputGroupEntity1.setLegend("Dados do locador");
		inputGroupEntity1.setInputList(List.of(input1, input2, input3, input4));

		inputGroupEntity1.getInputList().forEach(i -> i.setInputGroup(inputGroupEntity1));
		inputGroupRepository.save(inputGroupEntity1);

		InputEntity input5 = new InputEntity();
		input5.setName("nomeLocatario");
		input5.setLabel("Nome do Locatário");
		input5.setOrdem(5);
		input5.setType(InputType.TEXT);
		input5.setTitle(input5.getLabel());
		input5.setRequired(true);

		InputEntity input6 = new InputEntity();
		input6.setName("cpfLocatario");
		input6.setLabel("CPF do Locatário");
		input6.setOrdem(6);
		input6.setType(InputType.TEXT);
		input6.setTitle(input6.getLabel());

		InputEntity input7 = new InputEntity();
		input7.setName("identidadeLocatario");
		input7.setLabel("RG do Locatário");
		input7.setOrdem(7);
		input7.setType(InputType.TEXT);
		input7.setTitle(input7.getLabel());

		InputEntity input8 = new InputEntity();
		input8.setName("enderecoLocatario");
		input8.setLabel("Endereço do Locatário");
		input8.setOrdem(8);
		input8.setType(InputType.TEXT);
		input8.setTitle(input8.getLabel());

		InputEntity input9 = new InputEntity();
		input9.setName("tempoLocacao");
		input9.setLabel("Tempo de locação");
		input9.setOrdem(9);
		input9.setType(InputType.NUMBER);
		input9.setTitle(input9.getLabel());

		InputEntity input10 = new InputEntity();
		input10.setName("dataInicioLocacao");
		input10.setLabel("Data de Início da locação");
		input10.setOrdem(10);
		input10.setType(InputType.TEXT);
		input10.setTitle(input10.getLabel());

		InputEntity input11 = new InputEntity();
		input11.setName("dataFimLocacao");
		input11.setLabel("Data de fim da locação");
		input11.setOrdem(11);
		input11.setType(InputType.TEXT);
		input11.setTitle(input11.getLabel());

		InputEntity input12 = new InputEntity();
		input12.setName("valorAluguel");
		input12.setLabel("Valor do aluguel");
		input12.setOrdem(12);
		input12.setType(InputType.NUMBER);
		input12.setTitle(input12.getLabel());

		InputEntity input13 = new InputEntity();
		input13.setName("nomeFiador");
		input13.setLabel("Nome do fiador");
		input13.setOrdem(13);
		input13.setType(InputType.TEXT);
		input13.setTitle(input13.getLabel());

		InputEntity input14 = new InputEntity();
		input14.setName("cpfFiador");
		input14.setLabel("CPF do fiador");
		input14.setOrdem(14);
		input14.setType(InputType.TEXT);
		input14.setTitle(input14.getLabel());

		InputEntity input15 = new InputEntity();
		input15.setName("identidadeFiador");
		input15.setLabel("RG do fiador");
		input15.setOrdem(15);
		input15.setType(InputType.TEXT);
		input15.setTitle(input15.getLabel());

		InputEntity input16 = new InputEntity();
		input16.setName("enderecoFiador");
		input16.setLabel("Endereço do fiador");
		input16.setOrdem(16);
		input16.setType(InputType.TEXT);
		input16.setTitle(input16.getLabel());

		InputEntity input17 = new InputEntity();
		input17.setName("nomeTestemunha1");
		input17.setLabel("Nome da primeira testemunha");
		input17.setOrdem(17);
		input17.setType(InputType.TEXT);
		input17.setTitle(input17.getLabel());

		InputEntity input18 = new InputEntity();
		input18.setName("identidadeTestemunha1");
		input18.setLabel("RG da primeira testemunha");
		input18.setOrdem(18);
		input18.setType(InputType.TEXT);
		input18.setTitle(input18.getLabel());

		InputEntity input19 = new InputEntity();
		input19.setName("nomeTestemunha2");
		input19.setLabel("Nome da segunda testemunha");
		input19.setOrdem(19);
		input19.setType(InputType.TEXT);
		input19.setTitle(input19.getLabel());

		InputEntity input20 = new InputEntity();
		input20.setName("identidadeTestemunha2");
		input20.setLabel("RG da segunda testemunha");
		input20.setOrdem(20);
		input20.setType(InputType.TEXT);
		input20.setTitle(input20.getLabel());

		InputEntity input21 = new InputEntity();
		input21.setName("diaPagamentoAluguel");
		input21.setLabel("Dia do pagamento do aluguel");
		input21.setOrdem(21);
		input21.setType(InputType.NUMBER);
		input21.setTitle(input21.getLabel());

		InputGroupEntity inputGroupEntity2 = new InputGroupEntity();
		inputGroupEntity2.setOrdem(2);
		inputGroupEntity2.setTemplate(templateEntity);
		inputGroupEntity2.setLegend("Dados do locatário");
		inputGroupEntity2.setInputList(List.of(input5, input6, input7, input8, input9, input10, input11, input12, input13,
				input14, input15, input16, input17, input18, input19, input20, input21));

		inputGroupEntity2.getInputList().forEach(i -> i.setInputGroup(inputGroupEntity2));
		inputGroupRepository.save(inputGroupEntity2);
	}

}
