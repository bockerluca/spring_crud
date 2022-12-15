package com.example.f1kotprog.controller;

import com.example.f1kotprog.model.First;
import com.example.f1kotprog.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FirstController {


    @Autowired
    FirstService firstService;

    @RequestMapping(value="/first", method= RequestMethod.GET)
    public ModelAndView first() {

        List<First> list = firstService.getFirst();

        ModelAndView modelAndView = new ModelAndView("first");
        modelAndView.addObject("first", list);
        return modelAndView;
    }
}
