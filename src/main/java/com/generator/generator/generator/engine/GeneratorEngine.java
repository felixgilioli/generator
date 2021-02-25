package com.generator.generator.generator.engine;

/**
 * Interface responsável por definir o corpo de um determinado gerador.
 */
public interface GeneratorEngine {

    /**
     * Retorna o nome do tipo que será exibida no botão de geração.
     * @return nome do tipo.
     */
    String getLabel();

    /**
     * Retorna a extensão do arquivo que será gerado(ex: pdf).
     * @return extensão do arquivo.
     */
    String getExtension();

    /**
     * Retorna o contentType para geração do arquivo.
     * @return contentType.
     */
    String getContentType();

    /**
     * Método responsável por gerar o arquivo no formato definido.
     * @param templateInput template com valores informados.
     * @return objeto no formado definido.
     * @throws GeneratorException caso ocorra algum erro durante a geração do PDF.
     */
    Object generate(String templateInput) throws GeneratorException;
}
