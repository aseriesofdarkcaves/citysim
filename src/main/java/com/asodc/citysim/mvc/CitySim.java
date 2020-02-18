package com.asodc.citysim.mvc;

public class CitySim {
    private static CityModel city;
    private static CityView view;
    private static CityController controller;

    public static void main(String... args) {
        initCitySim();
    }

    private static void initCitySim() {
        city = new CityModel();
        view = new CityView();
        controller = new CityController(city, view);
    }
}
