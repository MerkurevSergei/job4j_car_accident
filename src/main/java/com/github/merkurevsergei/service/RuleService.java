package com.github.merkurevsergei.service;

import com.github.merkurevsergei.model.Rule;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RuleService {
    final private Set<Rule> rules;

    public RuleService() {
        this.rules = new HashSet<>();
        rules.add(Rule.of(1, "Статья 1."));
        rules.add(Rule.of(2, "Статья 2."));
        rules.add(Rule.of(3, "Статья 3."));
    }

    public Set<Rule> getAll() {
        return rules;
    }

    public Set<Rule> getByIds(String[] ids) {
        List<String> strIds = Arrays.asList(ids);
        return rules
                .stream()
                .filter(rule -> strIds.contains(String.valueOf(rule.getId())))
                .collect(Collectors.toSet());
    }
}
