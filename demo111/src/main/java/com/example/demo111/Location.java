package com.example.demo111;

public class Location {
    private String city;
    private String country;
    private String areaCode;


    public Location(String city, String country, String areaCode) {
        this.city = city;
        this.country = country;
        this.areaCode = areaCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAreaCode() {
        return areaCode;
    }
}
