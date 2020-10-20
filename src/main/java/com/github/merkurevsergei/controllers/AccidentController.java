package com.github.merkurevsergei.controllers;

import com.github.merkurevsergei.model.Accident;
import com.github.merkurevsergei.model.AccidentType;
import com.github.merkurevsergei.model.Rule;
import com.github.merkurevsergei.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class AccidentController {

    private final AccidentService accidentService;
    private final List<AccidentType> accidentTypes;
    private final Set<Rule> rules;

    public AccidentController(AccidentService accidentService) {
        this.accidentService = accidentService;
        accidentTypes = initAccidentTypes();
        rules = initRules();
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidentTypes);
        model.addAttribute("rules", rules);
        return "accident/create";
    }

    @GetMapping("/update")
    public String edit(@RequestParam("id") int id, Model model) {
        final Accident accident = accidentService.findById(id);
        model.addAttribute("accident", accident);
        model.addAttribute("types", accidentTypes);
        model.addAttribute("rules", rules);
        return "accident/update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        AccidentType accidentType = accidentTypes.get(accident.getType().getId());
        accident.setType(accidentType);
        String[] ids = Optional.ofNullable(req.getParameterValues("ruleIds")).orElse(new String[0]);
        List<String> strIds = Arrays.asList(ids);
        Set<Rule> selectedRules = this.rules
                .stream()
                .filter(rule -> strIds.contains(String.valueOf(rule.getId())))
                .collect(Collectors.toSet());
        accident.setRules(selectedRules);
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

    private Set<Rule> initRules() {
        Set<Rule> rules = new HashSet<>();
        rules.add(Rule.of(1, "Статья 1."));
        rules.add(Rule.of(2, "Статья 2."));
        rules.add(Rule.of(3, "Статья 3."));
        return rules;
    }
}
