package com.asodc.citysim.mvc;

public class CitySim {
    public static void main(String... args) {
        initCitySim();
    }

    private static void initCitySim() {
        // passive MVC model - controller updates both model and view when notified
        CityModel model = new CityModel();
        CityView view = new CityView();
        view.setLayoutDebugMode(true);
        CityController controller = new CityController(model, view);
    }
}
