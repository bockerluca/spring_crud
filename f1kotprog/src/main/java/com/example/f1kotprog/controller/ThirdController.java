package com.example.f1kotprog.controller;

 import com.example.f1kotprog.model.Third;
 import com.example.f1kotprog.service.ThirdService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ThirdController {
    @Autowired
    ThirdService thirdService;

    @RequestMapping(value="/third", method= RequestMethod.GET)
    public ModelAndView third() {

        List<Third> list = thirdService.getThird();

        ModelAndView modelAndView = new ModelAndView("third");
        modelAndView.addObject("third", list);
        return modelAndView;
    }
}
