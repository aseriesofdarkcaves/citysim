package com.asodc.citysim.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitySimController {
    private CityModel cityModel;
    private CitySimView view;

    public CitySimController(CityModel cityModel, CitySimView view) {
        this.cityModel = cityModel;
        this.view = view;
        attachActionListeners();
    }

    private void attachActionListeners() {
        view.getGenerateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // update the model
                cityModel = new CityModel(view.getWidthInput(), view.getHeightInput());
                // update the view by passing the new model to it
                view.update(cityModel);
            }
        });
    }
}
