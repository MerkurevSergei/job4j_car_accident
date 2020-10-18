package com.github.merkurevsergei.repository;

import com.github.merkurevsergei.model.Accident;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
public class AccidentsMem {
    private final Map<Integer, Accident> accidents = new HashMap<>();

    public void addAccident(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    public Accident getAccident(int id) {
        return accidents.getOrDefault(id, new Accident());
    }
}
