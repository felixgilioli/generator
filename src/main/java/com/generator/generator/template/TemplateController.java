package com.generator.generator.template;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping("/{templateId}/generate")
    public ModelAndView generate(@PathVariable String templateId) {
        final Optional<TemplateEntity> template = this.templateService.findById(UUID.fromString(templateId));
        return new ModelAndView("generator")
                .addObject("template", template.orElseThrow(() -> new IllegalArgumentException("templateId not found: " + templateId)));
    }

}
