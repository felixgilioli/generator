package com.generator.generator.template;

public enum ExportType {
    HTML("HTML", "html", "text/html"),
    TEXT("Texto", "txt", "text/plain"),
    PDF("PDF", "pdf", "application/pdf"),
    PNG("PNG", "png", "image/png");

    private final String label;
    private final String extension;
    private final String blobType;

    ExportType(String label, String extension, String blobType) {
        this.label = label;
        this.extension = extension;
        this.blobType = blobType;
    }

    public String getLabel() {
        return label;
    }

    public String getExtension() {
        return extension;
    }

    public String getBlobType() {
        return blobType;
    }
}
