package com.generator.generator.template;

public enum ExportType {
    HTML("HTML"),
    TEXT("Texto"),
    PDF("PDF"),
    PNG("PNG");

    private final String label;

    ExportType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
