package com.asodc.citysim.mvc;

import javax.swing.*;

public class CitySim {
    public static void main(String... args) {
        // use event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                startCitySim();
            }
        });
    }

    private static void startCitySim() {
        // passive MVC model - controller updates both model and view
        CityModel cityModel = new CityModel();

        CitySimView view = new CitySimView();
        view.setLayoutDebugMode(true);

        CitySimController controller = new CitySimController(cityModel, view);
    }
}
