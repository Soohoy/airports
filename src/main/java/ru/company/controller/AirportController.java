package ru.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.company.service.AirportService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class AirportController {

    @Autowired
    AirportService airportService;

    @RequestMapping(
            value = "/filter/country/",
            method = RequestMethod.GET)
    ResponseEntity<List<String>> getCountryFilter() {
        Set<String> setComboBox = airportService.getFilterData();
        List<String> list = new ArrayList<>();
        for(String s : setComboBox){
            list.add(s);
        }
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/airport/country/{countryValue}",
            method = RequestMethod.GET)
    ResponseEntity<List<List<String>>> getFilteredResult(@PathVariable String countryValue) {
        List<List<String>> list = null;
        if(countryValue != null) {
            if (countryValue.equals("")) {
                list = new ArrayList<>();
            } else {
                list = airportService.filteredAirports(countryValue);
            }
        }
        return new ResponseEntity<List<List<String>>>(list, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/airport/country/",
            method = RequestMethod.GET)
    ResponseEntity<List<List<String>>> getAllResult() {
        List<List<String>> list = null;
        list = airportService.filteredAirports("");
        return new ResponseEntity<List<List<String>>>(list, HttpStatus.OK);
    }

}
