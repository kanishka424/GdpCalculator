package com.kanishka.gdpcalculator.repository;

//import com.kanishka.gdpcalculator.model.CountryGdp;
import com.kanishka.gdpcalculator.model.CountryGdp;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GdpRepository extends JpaRepository<CountryGdp,Integer> {
    @Query("SELECT e FROM CountryGdp e WHERE e.year = :year AND (e.country_code.alpha3Code = :countryName OR  e.country_code.alpha2Code = :countryName) " )
    Optional<CountryGdp> findGdpByYear(int year, String countryName);
}
