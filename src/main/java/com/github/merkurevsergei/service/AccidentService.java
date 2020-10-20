package com.github.merkurevsergei.service;

import com.github.merkurevsergei.model.Accident;
import com.github.merkurevsergei.model.AccidentType;
import com.github.merkurevsergei.repository.AccidentJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccidentService {
    private final AccidentJdbcTemplate accidents;

    public AccidentService(AccidentJdbcTemplate accidents) {
        this.accidents = accidents;
        create(new Accident(0,
                "Персона 1",
                "Accident 1",
                "Street 1",
                AccidentType.of(1, "Две машины")));
        create(new Accident(1,
                "Person 2",
                "Accident 2",
                "Street 2",
                AccidentType.of(1, "Две машины")));
        create(new Accident(2,
                "Person 3",
                "Accident 3",
                "Street 3",
                AccidentType.of(1, "Две машины")));
    }

    public Accident findById(int id) {
        return null;
//                accidents.findById(id);
    }

    public void create(Accident accident) {
        accidents.save(accident);
    }

    public Object findAll() {
        return accidents.getAll();
    }
}
