package com.generator.generator.entityfactory.template;

import com.generator.generator.category.CategoryEntity;
import com.generator.generator.category.CategoryRepository;
import com.generator.generator.input.InputEntity;
import com.generator.generator.input.InputType;
import com.generator.generator.inputgroup.InputGroupEntity;
import com.generator.generator.inputgroup.InputGroupRepository;
import com.generator.generator.template.ExportType;
import com.generator.generator.template.TemplateEntity;
import com.generator.generator.template.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ContratoAluguelTemplateFactory implements TemplateFactory{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private InputGroupRepository inputGroupRepository;

    @Override
    public void create() {
        Optional<CategoryEntity> categoryEntity = this.categoryRepository.findByName("Contrato");
        if (categoryEntity.isEmpty()) {
            return;
        }

        TemplateEntity templateEntity = TemplateEntity.builder()
                .category(categoryEntity.get())
                .title("Contrato de Locação Residencial")
                .description("Um Contrato de Locação Residencial é um documento legal assinado entre o proprietário da propriedade, " +
                        "como apartamento, casa, vila, etc., e um indivíduo ou empresa que deseja alugar a propriedade. " +
                        "Este contrato de locação residencial delineia os arranjos legais mútuos entre estas duas partes e contém todas as " +
                        "várias cláusulas e termos que descrevem o acordo entre as duas partes.")
                .exportTypeSet(Set.of(ExportType.PDF))
                .location("/templates/template-contrato-aluguel.ftl")
                .imgLocation("/img/contrato-aluguel.png")
                .build();

        templateEntity = this.templateRepository.save(templateEntity);

        createInputsDadosProprietario(templateEntity);
        createInputsDadosLocatario(templateEntity);
        createInputsDadosLocacao(templateEntity);
    }

    private void createInputsDadosProprietario(TemplateEntity templateEntity) {
        InputEntity inputFullNameProprietario = InputEntity.builder()
                .label("Nome completo")
                .name("fullNameProprietario")
                .type(InputType.TEXT)
                .required(true)
                .ordem(0)
                .build();

        InputEntity inputEnderecoProprietario = InputEntity.builder()
                .label("Endereço")
                .name("enderecoProprietario")
                .type(InputType.TEXT)
                .required(true)
                .ordem(1)
                .build();

        InputGroupEntity groupProprietario = InputGroupEntity.builder()
                .template(templateEntity)
                .legend("Dados do Proprietário")
                .inputList(List.of(inputFullNameProprietario, inputEnderecoProprietario))
                .ordem(0)
                .build();

        groupProprietario.getInputList().forEach(i -> i.setInputGroup(groupProprietario));
        this.inputGroupRepository.save(groupProprietario);
    }

    private void createInputsDadosLocatario(TemplateEntity templateEntity) {
        InputEntity inputFullNameLocatario = InputEntity.builder()
                .label("Nome completo")
                .type(InputType.TEXT)
                .name("fullNameLocatario")
                .required(true)
                .ordem(0)
                .build();

        InputEntity inputEnderecoLocatario = InputEntity.builder()
                .label("Endereço")
                .type(InputType.TEXT)
                .name("enderecoLocatario")
                .required(true)
                .ordem(1)
                .build();

        InputGroupEntity groupLocatario = InputGroupEntity.builder()
                .template(templateEntity)
                .legend("Dados do Locatário")
                .inputList(List.of(inputFullNameLocatario, inputEnderecoLocatario))
                .ordem(1)
                .build();

        groupLocatario.getInputList().forEach(i -> i.setInputGroup(groupLocatario));
        this.inputGroupRepository.save(groupLocatario);
    }

    private void createInputsDadosLocacao(TemplateEntity templateEntity) {
        InputEntity inputEnderecoPropriedade = InputEntity.builder()
                .label("Endereço da propriedade")
                .name("enderecoPropriedade")
                .type(InputType.TEXT)
                .required(true)
                .ordem(0)
                .build();

        InputEntity diaFirmacaoContrato = InputEntity.builder()
                .label("Data de firmação do contrato")
                .name("diaFirmacaoContrato")
                .type(InputType.TEXT)
                .required(true)
                .ordem(1)
                .build();

        InputEntity mesFirmacaoContrato = InputEntity.builder()
                .label("Data de firmação do contrato")
                .name("mesFirmacaoContrato")
                .type(InputType.TEXT)
                .required(true)
                .ordem(2)
                .build();

        InputEntity anoFirmacaoContrato = InputEntity.builder()
                .label("Data de firmação do contrato")
                .name("anoFirmacaoContrato")
                .type(InputType.TEXT)
                .required(true)
                .ordem(3)
                .build();

        InputEntity inputInicioDataMudanca = InputEntity.builder()
                .label("Data da mudança")
                .name("dataDaMudanca")
                .mask("99/99/9999")
                .type(InputType.MASK)
                .required(true)
                .ordem(4)
                .build();

        InputEntity inputDataFinalDaLocacao = InputEntity.builder()
                .label("Data de fim do contrato")
                .name("dataFinalDaLocacao")
                .mask("99/99/9999")
                .type(InputType.MASK)
                .required(true)
                .ordem(5)
                .build();

        InputEntity inputValorAluguel = InputEntity.builder()
                .label("Valor do aluguel (R$)")
                .name("valorAluguel")
                .type(InputType.TEXT)
                .required(true)
                .ordem(6)
                .build();

        InputEntity inputValorAluguelPorEscrito = InputEntity.builder()
                .label("Valor do aluguel por escrito")
                .name("valorAluguelPorEscrito")
                .type(InputType.TEXT)
                .required(true)
                .ordem(7)
                .build();

        InputEntity inputDiaPagamentoAluguel = InputEntity.builder()
                .label("Dia do pagamento do aluguel")
                .name("diaPagamentoAluguel")
                .type(InputType.NUMBER)
                .required(true)
                .ordem(8)
                .build();

        InputEntity inputMetodoELocalDePagamento = InputEntity.builder()
                .label("Método e local de pagamento")
                .name("metodoELocalDePagamento")
                .type(InputType.TEXT)
                .required(true)
                .ordem(9)
                .build();

        InputEntity inputJurosPorDiaAtraso = InputEntity.builder()
                .label("Juros por dia de atraso (R$)")
                .name("jurosPorDiaAtraso")
                .type(InputType.NUMBER)
                .required(true)
                .ordem(10)
                .build();

        InputEntity inputMaximoDiasAtraso = InputEntity.builder()
                .label("Máximo de dias em atraso")
                .name("maximoDiasAtraso")
                .type(InputType.NUMBER)
                .required(true)
                .ordem(11)
                .build();

        InputEntity inputValorDepositoCaucao = InputEntity.builder()
                .label("Valor do depósito caução")
                .name("valorDepositoCaucao")
                .type(InputType.TEXT)
                .required(true)
                .ordem(12)
                .build();

        InputEntity inputNumeroMaxPessoas = InputEntity.builder()
                .label("Número máximo de pessoas permitidas")
                .name("numeroMaxPessoas")
                .type(InputType.NUMBER)
                .required(true)
                .ordem(13)
                .build();

        InputEntity inputNumeroMaxPessoasAbaixo18anos = InputEntity.builder()
                .label("Número máximo de pessoas permitidas abaixo de 18 anos")
                .name("numeroMaxPessoasAbaixo18anos")
                .type(InputType.NUMBER)
                .required(true)
                .ordem(14)
                .build();

        InputEntity inputServicosFornecidosPeloProprietario = InputEntity.builder()
                .label("Serviços fornecidos pelo proprietário")
                .name("servicosFornecidosPeloProprietario")
                .type(InputType.TEXTAREA)
                .required(true)
                .ordem(15)
                .build();

        InputEntity inputEstadoDaLeiEstadual = InputEntity.builder()
                .label("Estado da lei vigente")
                .name("estadoDaLeiEstadual")
                .type(InputType.TEXT)
                .required(true)
                .ordem(16)
                .build();

        InputGroupEntity groupLocatario = InputGroupEntity.builder()
                .template(templateEntity)
                .legend("Dados da Locação")
                .inputList(List.of(inputEnderecoPropriedade,
                        diaFirmacaoContrato,
                        mesFirmacaoContrato,
                        anoFirmacaoContrato,
                        inputInicioDataMudanca,
                        inputDataFinalDaLocacao,
                        inputValorAluguel,
                        inputValorAluguelPorEscrito,
                        inputDiaPagamentoAluguel,
                        inputMetodoELocalDePagamento,
                        inputJurosPorDiaAtraso,
                        inputMaximoDiasAtraso,
                        inputValorDepositoCaucao,
                        inputNumeroMaxPessoas,
                        inputNumeroMaxPessoasAbaixo18anos,
                        inputServicosFornecidosPeloProprietario,
                        inputEstadoDaLeiEstadual))
                .ordem(2)
                .build();

        groupLocatario.getInputList().forEach(i -> i.setInputGroup(groupLocatario));
        this.inputGroupRepository.save(groupLocatario);
    }
}
