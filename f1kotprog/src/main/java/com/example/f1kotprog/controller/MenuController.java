package com.example.f1kotprog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public ModelAndView menu() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("menu");
        return mav;
    }

}
