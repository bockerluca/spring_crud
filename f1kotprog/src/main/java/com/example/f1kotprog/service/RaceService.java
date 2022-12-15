package com.example.f1kotprog.service;

import com.example.f1kotprog.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class RaceService {

    @Autowired
    JdbcTemplate template;

    public List<Race> getRaces() {
        return template.query("SELECT * FROM races ORDER BY raceID DESC", new RowMapper<Race>() {
            public Race mapRow(ResultSet rs, int row) throws SQLException {
                Race r = new Race();
                r.setRaceId(rs.getInt(1));
                r.setYear(rs.getInt(2));
                r.setRound(rs.getInt(3));
                r.setCircuitId(rs.getInt(4));
                r.setName(rs.getString(5));
                r.setDate(rs.getString(6));
                return r;
            }
        });
    }
}
