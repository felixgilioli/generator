package com.generator.generator.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generator")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @PostMapping
    public ResponseEntity<String> generate(@RequestBody GeneratorDTO generatorDTO) {
        final String document = this.generatorService.generate(generatorDTO);
        return ResponseEntity.ok(document);
    }

}
