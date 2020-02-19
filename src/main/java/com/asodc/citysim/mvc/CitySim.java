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
        // passive MVC model - controller updates both model and view when notified
        CityModel model = new CityModel();
        CityView view = new CityView();
        view.setLayoutDebugMode(true);
        CityController controller = new CityController(model, view);
    }
}
