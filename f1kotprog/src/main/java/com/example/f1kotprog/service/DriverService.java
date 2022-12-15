package com.example.f1kotprog.service;

import com.example.f1kotprog.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    JdbcTemplate template;

    public void addNew(Driver d) {
        String sql = "INSERT into drivers SET number='" + d.getNumber() + "', forname='" + d.getForname() + "', surname='" + d.getSurname() +
                "', dob='" + d.getDob() + "', nationality='" + d.getNationality() + "'";
        template.update(sql);
    }

    public void update(Driver d) {
        String sql = "UPDATE drivers SET driverId=" + d.getDriverId() + ", number='" + d.getNumber() + "', forname='" + d.getForname() + "', surname='" + d.getSurname() +
                "', dob='" + d.getDob() + "', nationality='" + d.getNationality() + "' WHERE driverId=" + d.getDriverId();
        template.update(sql);
    }

    public void delete(int driverId) {
        String sql = "UPDATE drivers SET softDeleted=true WHERE driverId=" + driverId + "";
        template.update(sql);
    }

    public Driver getDriverById(int driverId) {
        String sql = "SELECT * FROM drivers WHERE driverId = ?";
        return template.queryForObject(sql, new Object[]{driverId}, new BeanPropertyRowMapper<Driver>(Driver.class));
    }

    public List<Driver> getDrivers() {
        return template.query("SELECT * FROM drivers WHERE softDeleted = false ORDER BY driverID DESC", new RowMapper<Driver>() {
            public Driver mapRow(ResultSet rs, int row) throws SQLException {
                Driver d = new Driver();
                d.setDriverId(rs.getInt(1));
                d.setNumber(rs.getString(2));
                d.setForname(rs.getString(3));
                d.setSurname(rs.getString(4));
                d.setDob(rs.getString(5));
                d.setNationality(rs.getString(6));
                return d;
            }
        });
    }
}
