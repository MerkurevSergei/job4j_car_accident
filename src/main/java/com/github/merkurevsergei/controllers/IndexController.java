package com.github.merkurevsergei.controllers;

import com.github.merkurevsergei.model.Accident;
import com.github.merkurevsergei.repository.AccidentsMem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        final AccidentsMem accidentsMem = new AccidentsMem();
        accidentsMem.addAccident(new Accident(1, "Person 1", "Accident 1", "Street 1"));
        accidentsMem.addAccident(new Accident(2, "Person 2", "Accident 2", "Street 2"));
        accidentsMem.addAccident(new Accident(3, "Person 3", "Accident 3", "Street 3"));
        model.addAttribute("accidents", accidentsMem.getAccidents());
        return "index";
    }
}
