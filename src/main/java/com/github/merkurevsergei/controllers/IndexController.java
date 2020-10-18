package com.github.merkurevsergei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        final List<String> list = List.of("One", "Two", "Three");
        model.addAttribute("list", list);
        return "index";
    }
}
