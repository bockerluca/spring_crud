package com.example.f1kotprog.service;

import com.example.f1kotprog.model.First;
import com.example.f1kotprog.model.Third;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ThirdService {
    @Autowired
    JdbcTemplate template;

    public List<Third> getThird() {
        String sql="SELECT d.forname, d.surname FROM drivers AS d INNER JOIN results re ON re.driverId=d.driverId INNER JOIN races r ON r.raceId=re.raceId WHERE r.name IN (SELECT r.name FROM races AS r GROUP BY r.name HAVING r.name=\"Australian Grand Prix\")";
        return template.query(sql, new RowMapper<Third>() {
            public Third mapRow(ResultSet rs, int row) throws SQLException {
                Third t = new Third();
                t.setForname(rs.getString(1));
                t.setSurname(rs.getString(2));
                return t;
            }
        });
    }
}
