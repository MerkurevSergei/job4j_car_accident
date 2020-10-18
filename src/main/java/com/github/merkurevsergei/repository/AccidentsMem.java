package com.github.merkurevsergei.repository;

import com.github.merkurevsergei.model.Accident;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
public class AccidentsMem {
    private final Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentsMem() {
        create(new Accident(1, "Персона 1", "Accident 1", "Street 1"));
        create(new Accident(2, "Person 2", "Accident 2", "Street 2"));
        create(new Accident(3, "Person 3", "Accident 3", "Street 3"));
    }

    public void create(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }
}
