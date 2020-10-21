package com.github.merkurevsergei.controllers;

import com.github.merkurevsergei.model.Accident;
import com.github.merkurevsergei.model.Rule;
import com.github.merkurevsergei.service.AccidentService;
import com.github.merkurevsergei.service.RuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class AccidentController {

    private final AccidentService accidentService;
    private final RuleService ruleService;

    public AccidentController(AccidentService accidentService, RuleService ruleService) {
        this.accidentService = accidentService;
        this.ruleService = ruleService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidentService.getTypes());
        model.addAttribute("rules", ruleService.getAll());
        return "accident/create";
    }

    @GetMapping("/update")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidentService.findById(id));
        model.addAttribute("types", accidentService.getTypes());
        model.addAttribute("rules", ruleService.getAll());
        return "accident/update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = Optional.ofNullable(req.getParameterValues("ruleIds")).orElse(new String[0]);
        Set<Rule> rules = ruleService.getByIds(ids);
        accident.setRules(rules);
        accidentService.updateRelations(accident);
        accidentService.create(accident);
        return "redirect:/";
    }
}
