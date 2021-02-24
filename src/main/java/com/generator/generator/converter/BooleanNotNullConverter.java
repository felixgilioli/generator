package com.generator.generator.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Classe responsável por converter o valor de um boolean null para false.
 */
@Converter
public class BooleanNotNullConverter implements AttributeConverter<Boolean, Boolean> {

    /**
     * Caso o boolean passado seja null, é retornado false.
     * @param value boolean
     * @return false caso o valor passado seja null, do contrário retorna ele mesmo.
     */
    @Override
    public Boolean convertToDatabaseColumn(Boolean value) {
        return value == null ? Boolean.FALSE : value;
    }

    /**
     * Retorna o próprio valor recebido.
     * @param value boolean
     * @return o próprio valor recebido.
     */
    @Override
    public Boolean convertToEntityAttribute(Boolean value) {
        return value;
    }
}
