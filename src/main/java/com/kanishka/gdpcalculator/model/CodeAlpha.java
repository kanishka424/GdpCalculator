package com.kanishka.gdpcalculator.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CodeAlpha {

    private String country;
    private String alpha2Code;
    @Id
    private String alpha3Code;
    private int numericValue;


    public CodeAlpha() {

    }

    public CodeAlpha(String country, String alpha2Code, String alpha3Code, int numericValue) {
        this.country = country;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.numericValue = numericValue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public int getNumeric() {
        return numericValue;
    }

    public void setNumeric(int numeric) {
        this.numericValue = numeric;
    }
}
