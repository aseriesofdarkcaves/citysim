package com.asodc.citysim;

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
        // passive MVC model - controller updates both model and view on clicking of generate button
        CityModel city = new CityModel();
        CitySimView view = new CitySimView();
        CitySimController controller = new CitySimController(city, view);
    }
}
