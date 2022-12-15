package com.example.f1kotprog.controller;

import com.example.f1kotprog.model.Result;
import com.example.f1kotprog.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ResultController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ResultService resultService;

    @RequestMapping(value="/results", method= RequestMethod.GET)
    public ModelAndView results() {

        List<Result> list = resultService.getResults();

        ModelAndView modelAndView = new ModelAndView("results");
        modelAndView.addObject("results", list);
        return modelAndView;
    }

    // tablazatbol hivjuk
    @RequestMapping(value="/deleteresult",  params = "resultId", method=RequestMethod.GET)
    public ModelAndView deleteResultByIdAndRefresh(@RequestParam("resultId") int resultId) {
        resultService.delete(resultId);
        List<Result> list = resultService.getResults();
        ModelAndView modelAndView = new ModelAndView("results");
        modelAndView.addObject("results", list);
        return modelAndView;
    }
}
