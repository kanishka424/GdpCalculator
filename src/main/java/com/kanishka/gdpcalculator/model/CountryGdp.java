package com.kanishka.gdpcalculator.model;

import javax.persistence.*;

@Entity
public class CountryGdp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String country_name;
    @ManyToOne(targetEntity =CodeAlpha.class)
    @JoinColumn(name="country_code",nullable = true)
    private CodeAlpha country_code;
    private int year;
    private long gdpValue;


    public CountryGdp() {

    }

    public CountryGdp(int id, String country_name, CodeAlpha country_code, int year, long gdpValue) {
        this.id = id;
        this.country_name = country_name;
        this.country_code = country_code;
        this.year = year;
        this.gdpValue = gdpValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public CodeAlpha getCountry() {
        return country_code;
    }

    public void setCountry(CodeAlpha country) {
        this.country_code = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getGdpValue() {
        return gdpValue;
    }

    public void setGdpValue(long gdpValue) {
        this.gdpValue = gdpValue;
    }
}
