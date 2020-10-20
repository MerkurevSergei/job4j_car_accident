package com.github.merkurevsergei.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccidentType {
    @EqualsAndHashCode.Include
    private int id;
    private String name;

    public static AccidentType of(int id, String name) {
        AccidentType accidentType = new AccidentType();
        accidentType.id = id;
        accidentType.name = name;
        return accidentType;
    }
}
