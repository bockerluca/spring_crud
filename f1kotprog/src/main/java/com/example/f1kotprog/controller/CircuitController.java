package com.example.f1kotprog.controller;
import com.example.f1kotprog.model.Circuit;
import com.example.f1kotprog.service.CircuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CircuitController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CircuitService circuitService;

    @RequestMapping(value="/circuits", method= RequestMethod.GET)
    public ModelAndView circuits() {

        List<Circuit> list = circuitService.getCircuits();

        ModelAndView modelAndView = new ModelAndView("circuits");
        modelAndView.addObject("circuits", list);
        return modelAndView;
    }

    // tablazatbol hivjuk
    @GetMapping(value="/addnewcircuit")
    public ModelAndView openAddNewCircuit() {
        Circuit circuit = new Circuit("", "", "");
        ModelAndView modelAndView = new ModelAndView("addcircuitform");
        modelAndView.addObject("circuit", circuit);
        return modelAndView;
    }

    // html-bol hivjuk
    @RequestMapping(value = "/circuits/addnewcircuit", method = RequestMethod.POST)
    public ModelAndView addNewCircuitAndOpenCircuits(@ModelAttribute("circuit")Circuit circuit) {
        circuitService.addNew(circuit);

        List<Circuit> list = circuitService.getCircuits();

        ModelAndView modelAndView = new ModelAndView("circuits");
        modelAndView.addObject("circuits", list);
        return modelAndView;
    }

    // tablazatbol hivjuk
    @RequestMapping(value="/editcircuit",  params = "circuitId", method=RequestMethod.GET)
    public ModelAndView openCircuitEditorById(@RequestParam("circuitId") int circuitId) {
        Circuit circuit = circuitService.getCircuitById(circuitId);
        ModelAndView modelAndView = new ModelAndView("editcircuitform");
        modelAndView.addObject("circuit", circuit);
        return modelAndView;
    }

    // html-bol hivjuk
    @RequestMapping(value = "/circuits/saveeditedcircuit", method = RequestMethod.POST)
    public ModelAndView editCircuitAndOpenCircuits(@ModelAttribute("circuit")Circuit circuit) {
        circuitService.update(circuit);

        List<Circuit> list = circuitService.getCircuits();

        ModelAndView modelAndView = new ModelAndView("circuits");
        modelAndView.addObject("circuits", list);
        return modelAndView;
    }

    // tablazatbol hivjuk
    @RequestMapping(value="/deletecircuit",  params = "circuitId", method=RequestMethod.GET)
    public ModelAndView deleteCircuitByIdAndRefresh(@RequestParam("circuitId") int circuitId) {
        circuitService.delete(circuitId);
        List<Circuit> list = circuitService.getCircuits();
        ModelAndView modelAndView = new ModelAndView("circuits");
        modelAndView.addObject("circuits", list);
        return modelAndView;
    }
}
