package com.example.f1kotprog.controller;

import com.example.f1kotprog.model.Driver;
import com.example.f1kotprog.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DriverController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DriverService driverService;

    @RequestMapping(value="/drivers", method=RequestMethod.GET)
    public ModelAndView drivers() {

        List<Driver> list = driverService.getDrivers();

        ModelAndView modelAndView = new ModelAndView("drivers");
        modelAndView.addObject("drivers", list);
        return modelAndView;
    }

    // tablazatbol hivjuk
    @GetMapping(value="/addnewdriver")
    public ModelAndView openAddNewDriver() {
        Driver driver = new Driver("", "", "", "", "");
        ModelAndView modelAndView = new ModelAndView("adddriverform");
        modelAndView.addObject("driver", driver);
        return modelAndView;
    }

    // html-bol hivjuk
    @RequestMapping(value = "/drivers/addnewdriver", method = RequestMethod.POST)
    public ModelAndView addNewDriverAndOpenDrivers(@ModelAttribute("driver")Driver driver) {
        driverService.addNew(driver);

        List<Driver> list = driverService.getDrivers();

        ModelAndView modelAndView = new ModelAndView("drivers");
        modelAndView.addObject("drivers", list);
        return modelAndView;
    }

    // tablazatbol hivjuk
    @RequestMapping(value="/editdriver",  params = "driverId", method=RequestMethod.GET)
    public ModelAndView openDriverEditorById(@RequestParam("driverId") int driverId) {
        Driver driver = driverService.getDriverById(driverId);
        ModelAndView modelAndView = new ModelAndView("editdriverform");
        modelAndView.addObject("driver", driver);
        return modelAndView;
    }

    // html-bol hivjuk
    @RequestMapping(value = "/drivers/saveediteddriver", method = RequestMethod.POST)
    public ModelAndView editDriverAndOpenDrivers(@ModelAttribute("driver")Driver driver) {
        System.out.println("driver = " + driver.toString());
        driverService.update(driver);

        List<Driver> list = driverService.getDrivers();

        ModelAndView modelAndView = new ModelAndView("drivers");
        modelAndView.addObject("drivers", list);
        return modelAndView;
    }

    // tablazatbol hivjuk
    @RequestMapping(value="/deletedriver",  params = "driverId", method=RequestMethod.GET)
    public ModelAndView deleteDriverByIdAndRefresh(@RequestParam("driverId") int driverId) {
        driverService.delete(driverId);
        List<Driver> list = driverService.getDrivers();
        ModelAndView modelAndView = new ModelAndView("drivers");
        modelAndView.addObject("drivers", list);
        return modelAndView;
    }
}
