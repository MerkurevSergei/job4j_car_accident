package com.github.merkurevsergei.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccidentRule {
    @EqualsAndHashCode.Include
    private int id;
    private String name;

    public static AccidentRule of(int id, String name) {
        AccidentRule rule = new AccidentRule();
        rule.id = id;
        rule.name = name;
        return rule;
    }
}
