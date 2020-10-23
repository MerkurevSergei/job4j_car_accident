package com.github.merkurevsergei.service;

import com.github.merkurevsergei.model.Accident;
import com.github.merkurevsergei.model.AccidentType;
import com.github.merkurevsergei.model.AccidentRule;
import com.github.merkurevsergei.repository.AccidentJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AccidentService {
    private final AccidentJdbcTemplate accidentsDAO;

    public AccidentService(AccidentJdbcTemplate accidentsDAO) {
        this.accidentsDAO = accidentsDAO;
    }

    public List<Accident> findAllAccidents() {
        return accidentsDAO.findAllAccidents();
    }

    public Optional<Accident> findAccidentById(int id) {
        return accidentsDAO.findAccidentById(id);
    }

    public Optional<Accident> save(Accident accident) {
        Optional<Accident> result;
        if (accident.getId() != 0) {
            result = accidentsDAO.update(accident);
        } else {
             result = accidentsDAO.create(accident);
        }
        return result;
    }

    public Collection<AccidentType> findAllTypes() {
        return accidentsDAO.findAllTypes();
    }

    public Collection<AccidentRule> findAllRules() {
        return accidentsDAO.findAllRules();
    }
}
