package com.generator.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.generator.generator.template.TemplateEntity;
import com.generator.generator.template.TemplateService;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private TemplateService templateService;

    @GetMapping
    public ModelAndView get() {
        final Page<TemplateEntity> templatePage = this.templateService.findAllPageable(PageRequest.of(0, 20));
        return new ModelAndView("index")
                .addObject("templatePage", templatePage);
    }

}
