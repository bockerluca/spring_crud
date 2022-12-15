package com.example.f1kotprog.service;

import com.example.f1kotprog.model.Circuit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CircuitService {

    @Autowired
    JdbcTemplate template;

    public void addNew(Circuit c) {
        String sql = "INSERT into circuits SET name='" + c.getName() + "', location='" + c.getLocation() + "', country='" + c.getCountry() + "'";
        template.update(sql);
    }

    public void update(Circuit c) {
        String sql = "UPDATE circuits SET circuitId=" + c.getCircuitId() + ", name='" + c.getName() + "', location='" + c.getLocation() + "', country='" + c.getCircuitId() +
                "' WHERE circuitId=" + c.getCircuitId();
        template.update(sql);
    }

    public void delete(int circuitId) {
        String sql = "UPDATE circuits SET softDeleted=true WHERE circuitID=" + circuitId + "";
        template.update(sql);
    }

    public Circuit getCircuitById(int circuitId) {
        String sql = "SELECT * FROM circuits WHERE circuitId = ?";
        return template.queryForObject(sql, new Object[]{circuitId}, new BeanPropertyRowMapper<Circuit>(Circuit.class));
    }

    public List<Circuit> getCircuits() {
        return template.query("SELECT * FROM circuits WHERE softDeleted=false ORDER BY circuitID DESC", new RowMapper<Circuit>() {
            public Circuit mapRow(ResultSet rs, int row) throws SQLException {
                Circuit c = new Circuit();
                c.setCircuitId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setLocation(rs.getString(3));
                c.setCountry(rs.getString(4));
                return c;
            }
        });
    }
}

