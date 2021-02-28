package com.generator.generator.input;

public enum InputType {

    TEXT("Texto"),
    EMAIL("Email"),
    NUMBER("Número"),
    MASK("Máscara"),
    CALENDAR("Calendário"),
    TEXTAREA("Textarea");

    private final String label;

    InputType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
