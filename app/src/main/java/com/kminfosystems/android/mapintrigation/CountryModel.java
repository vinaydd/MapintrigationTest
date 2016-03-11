package com.kminfosystems.android.mapintrigation;

import java.io.Serializable;

/**
 * Created by kmidev on 2/1/16.
 */
public class CountryModel implements Serializable{
    String country_code;
    String country_name;

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

}
