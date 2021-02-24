package com.generator.generator.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanNotNullConverter implements AttributeConverter<Boolean, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(Boolean value) {
        return value == null ? Boolean.FALSE : value;
    }

    @Override
    public Boolean convertToEntityAttribute(Boolean value) {
        return value;
    }
}
