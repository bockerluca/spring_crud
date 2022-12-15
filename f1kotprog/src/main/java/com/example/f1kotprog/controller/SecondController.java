package com.example.f1kotprog.controller;

import com.example.f1kotprog.model.Second;
import com.example.f1kotprog.service.SecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SecondController {
    @Autowired
    SecondService secondService;

    @RequestMapping(value="/second", method= RequestMethod.GET)
    public ModelAndView second() {

        List<Second> list = secondService.getSecond();

        ModelAndView modelAndView = new ModelAndView("second");
        modelAndView.addObject("second", list);
        return modelAndView;
    }
}
