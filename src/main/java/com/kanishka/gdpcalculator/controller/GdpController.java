package com.kanishka.gdpcalculator.controller;



import com.kanishka.gdpcalculator.service.GdpByCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class GdpController {

    final GdpByCountryService  gdpByCountryService;

    @Autowired
    public GdpController(GdpByCountryService gdpByCountryService) {
        this.gdpByCountryService = gdpByCountryService;
    }


    @GetMapping("/countrygdp/{countryname}/{year}")
    public double getGdpByCountry(@PathVariable("countryname") String countryname, @PathVariable int year){

       return gdpByCountryService.getGdp(countryname,year);


    }

}
