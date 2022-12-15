package com.example.f1kotprog.controller;

import com.example.f1kotprog.model.Race;
import com.example.f1kotprog.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RaceController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RaceService raceService;

    @RequestMapping(value="/races", method= RequestMethod.GET)
    public ModelAndView races() {

        List<Race> list = raceService.getRaces();

        ModelAndView modelAndView = new ModelAndView("races");
        modelAndView.addObject("races", list);
        return modelAndView;
    }
}
