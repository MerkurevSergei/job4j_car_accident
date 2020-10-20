package com.github.merkurevsergei.controllers;

import com.github.merkurevsergei.model.Accident;
import com.github.merkurevsergei.model.AccidentType;
import com.github.merkurevsergei.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccidentController {

    private final AccidentService accidentService;
    private final List<AccidentType> accidentTypes;

    public AccidentController(AccidentService accidentService) {
        this.accidentService = accidentService;
        accidentTypes = initAccidentTypes();
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidentTypes);
        return "accident/create";
    }

    @GetMapping("/update")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", accidentTypes);
        final Accident accident = accidentService.findById(id);
        model.addAttribute("accident", accident);
        return "accident/update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        AccidentType accidentType = accidentTypes.get(accident.getType().getId());
        accident.setType(accidentType);
        accidentService.create(accident);
        return "redirect:/";
    }

    private List<AccidentType> initAccidentTypes() {
        List<AccidentType> types = new ArrayList<>();
        types.add(AccidentType.of(0, "Две машины"));
        types.add(AccidentType.of(1, "Машина и человек"));
        types.add(AccidentType.of(2, "Машина и велосипед"));
        return types;
    }
}
