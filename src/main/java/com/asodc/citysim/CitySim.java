package com.asodc.citysim;

import javax.swing.SwingUtilities;

public class CitySim {
    public static void main(String[] args) {
        // Use event dispatch thread, via method reference
        SwingUtilities.invokeLater(CitySim::startCitySim);
    }

    private static void startCitySim() {
        // passive MVC model - controller updates both model and view
        CityModel cityModel = new CityModel();

        CitySimView view = new CitySimView();
//        view.setLayoutDebugMode(true);

        new CitySimController(cityModel, view);
    }
}
