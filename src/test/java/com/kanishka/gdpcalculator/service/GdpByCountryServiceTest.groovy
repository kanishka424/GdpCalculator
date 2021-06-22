package com.kanishka.gdpcalculator.service

import com.kanishka.gdpcalculator.model.CodeAlpha
import com.kanishka.gdpcalculator.model.CountryGdp
import com.kanishka.gdpcalculator.repository.GdpRepository
import spock.lang.Specification

class GdpByCountryServiceTest  extends  Specification{

    def gdpRepository=Mock(GdpRepository)
    def gdpByCountryService=new GdpByCountryService(gdpRepository);
    def "getting Growth GDP"() {
        given:
        def codeAlpha=new CodeAlpha( "Albania","AL","ALB", 8);
        def gdpDetailsCurrentYearOptional=new CountryGdp(64,  "Albania",codeAlpha,  2009,12044212904);
        def gdpDetailsPreviousYearOptional=new CountryGdp(63,  "Albania",codeAlpha,  2008,12881352688);


        and:
        gdpRepository.findGdpByYear(2009, 'ALB')>>Optional.of(gdpDetailsCurrentYearOptional)
        gdpRepository.findGdpByYear(2008, 'ALB')>>Optional.of(gdpDetailsPreviousYearOptional)


        when:
        def getResult=gdpByCountryService.getGdp("ALB",2009)

        then:
        getResult==-6.498849959910359
    }
}
