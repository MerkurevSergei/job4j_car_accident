package com.github.merkurevsergei.repository;

import com.github.merkurevsergei.model.Accident;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Optional<Accident> findById(int id) {
        return Optional.empty();
//        return jdbc.queryForObject("select * from accident where id = ?",
//                new Object[] {id},
//                (rs, rowNum) ->
//                        new Accident(
//                                rs.getInt("id"),
//                                rs.getString("name"),
//                                rs.getString("address")
//                        ));
//                );
    }

    public Optional<Accident> save(Accident accident) {
        jdbc.update("insert into accident (name) values (?)",
                accident.getName());
        return Optional.of(accident);
    }

    public List<Accident> getAll() {
        return jdbc.query("select id, name from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }
}