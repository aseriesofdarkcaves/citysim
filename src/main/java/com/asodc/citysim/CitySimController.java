package com.asodc.citysim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CitySimController {
    private CityModel cityModel;
    private CitySimView view;

    CitySimController(CityModel cityModel, CitySimView view) {
        this.cityModel = cityModel;
        this.view = view;
        attachActionListeners();
    }

    private void attachActionListeners() {
        view.getGenerateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: extract GenerationStrategy to allow generation based on user input (combobox etc.)
                cityModel = new CityModel(new RandomCity(view.getWidthInput(), view.getHeightInput()));
                view.update(cityModel);
            }
        });
    }
}
