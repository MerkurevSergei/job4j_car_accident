package com.github.merkurevsergei.controllers;

import com.github.merkurevsergei.model.Accident;
import com.github.merkurevsergei.repository.AccidentsMem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccidentController {
    private final AccidentsMem accidents;

    public AccidentController(AccidentsMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        final Accident accident = accidents.findById(id);
        model.addAttribute("accident", accident);
        return "accident/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        accidents.create(accident);
        return "redirect:/";
    }
}
