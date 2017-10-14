package ru.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.company.entity.Airport;
import ru.company.service.AirportService;

@Controller
public class AirportController {

    @Autowired
    private AirportService airportService;

    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }

    @RequestMapping(value = "/")
    public String airportListByParam(@RequestParam(value = "country", required = false) String s, Model model){
        model.addAttribute("paramList",airportService.getListParam());
        model.addAttribute("airport", new Airport());
        model.addAttribute("airportList", airportService.getListByParam(s));
        return "index";
    }

}
