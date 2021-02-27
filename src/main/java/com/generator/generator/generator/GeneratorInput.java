package com.generator.generator.generator;

import java.util.Map;

import com.generator.generator.template.ExportType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratorInput {

    private ExportType type;
    private String templateId;
    private Map<String, Object> params;

    public Map<String, Object> getParams() {
        if (this.params == null) {
            return null;
        }
        this.params.keySet()
                .forEach(k -> {
                    if (this.params.get(k) == null) {
                        this.params.replace(k, "");
                    }
                });

        return this.params;
    }
}
