package com.example.f1kotprog.service;

import com.example.f1kotprog.model.Driver;
import com.example.f1kotprog.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ResultService {

    @Autowired
    JdbcTemplate template;

    public void delete(int resultId) {
        String sql = "DELETE FROM results WHERE resultId=" + resultId + "";
        template.update(sql);
    }

    public Driver getDriverById(int resultId) {
        String sql = "SELECT * FROM results WHERE resultId = ?";
        return template.queryForObject(sql, new Object[]{resultId}, new BeanPropertyRowMapper<Driver>(Driver.class));
    }

    public List<Result> getResults() {
        return template.query("SELECT * FROM results ORDER BY resultID DESC", new RowMapper<Result>() {
            public Result mapRow(ResultSet rs, int row) throws SQLException {
                Result r = new Result();
                r.setResultId(rs.getInt(1));
                r.setRaceId(rs.getInt(2));
                r.setDriverId(rs.getInt(3));
                r.setNumber(rs.getString(4));
                r.setGrid(rs.getInt(5));
                r.setPositionOrder(rs.getInt(6));
                r.setPoints(rs.getInt(7));
                return r;
            }
        });
    }
}
