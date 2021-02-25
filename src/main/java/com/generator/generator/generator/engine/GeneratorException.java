package com.generator.generator.generator.engine;

/**
 * Exception que representa erros causados durante a geração de documentos.
 */
public class GeneratorException extends Exception {

    /**
     * Construtor vazio.
     */
    public GeneratorException() {
        super();
    }

    /**
     * Construtor com mensagem que será exibida no stacktrace.
     * @param message mensagem.
     */
    public GeneratorException(String message) {
        super(message);
    }
}
