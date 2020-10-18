package com.github.merkurevsergei.controllers;

import com.github.merkurevsergei.model.Accident;
import com.github.merkurevsergei.repository.AccidentsMem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final AccidentsMem accidents;

    public IndexController(AccidentsMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidents.getAccidents());
        return "index";
    }
}
