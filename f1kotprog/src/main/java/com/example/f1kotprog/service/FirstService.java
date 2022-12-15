package com.example.f1kotprog.service;

import com.example.f1kotprog.model.First;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class FirstService {

    @Autowired
    JdbcTemplate template;

    public List<First> getFirst() {
        String sql="SELECT d.forname, d.surname, COUNT(d.driverId) AS mostP3Win FROM results AS r INNER JOIN drivers d ON d.driverId=r.driverId WHERE grid=3 AND positionOrder=1 GROUP BY d.driverId ORDER BY COUNT(d.driverID) DESC LIMIT 1";
        return template.query(sql, new RowMapper<First>() {
            public First mapRow(ResultSet rs, int row) throws SQLException {
                First f = new First();
                f.setForname(rs.getString(1));
                f.setSurname(rs.getString(2));
                f.setMostP3Win(rs.getInt(3));
                return f;
            }
        });
    }
}
