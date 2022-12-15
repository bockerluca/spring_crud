package com.example.f1kotprog.service;

import com.example.f1kotprog.model.First;
import com.example.f1kotprog.model.Second;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SecondService {
    @Autowired
    JdbcTemplate template;

    public List<Second> getSecond() {
        String sql="SELECT c.name, c.location, c.country, COUNT(c.name) AS countOfRaces FROM circuits AS c INNER JOIN races r ON r.circuitId=c.circuitId GROUP BY c.name HAVING countOfRaces=4 ORDER BY COUNT(c.circuitId)\n";
        return template.query(sql, new RowMapper<Second>() {
            public Second mapRow(ResultSet rs, int row) throws SQLException {
                Second s = new Second();
                s.setName(rs.getString(1));
                s.setLocation(rs.getString(2));
                s.setCountry(rs.getString(3));
                s.setCountOfRaces(rs.getInt(4));
                return s;
            }
        });
    }
}
