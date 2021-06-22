package com.kanishka.gdpcalculator.service;


import com.kanishka.gdpcalculator.model.CountryGdp;
import com.kanishka.gdpcalculator.repository.GdpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GdpByCountryService {


    private final GdpRepository gdpRepository;

    @Autowired
    public GdpByCountryService(GdpRepository gdpRepository) {
        this.gdpRepository = gdpRepository;
    }

    public double getGdp(String countryName, int year) {


            Optional<CountryGdp> gdpDetailsCurrentYearOptional = gdpRepository.findGdpByYear(year, countryName);
            Optional<CountryGdp> gdpDetailsPreviousYearOptional = gdpRepository.findGdpByYear(year - 1, countryName);
            if (gdpDetailsCurrentYearOptional.isPresent() && gdpDetailsPreviousYearOptional.isPresent()) {
                long currentYearGdpValue = gdpDetailsCurrentYearOptional.get().getGdpValue();
                long previousYearGdpValue = gdpDetailsPreviousYearOptional.get().getGdpValue();
                double gdpGrowthRate = (double) (currentYearGdpValue - previousYearGdpValue) / previousYearGdpValue * 100;
                return gdpGrowthRate;
            }

        throw new RuntimeException("Requested data not consistent for given year");

    }


}
