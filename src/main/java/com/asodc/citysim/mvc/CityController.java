package com.asodc.citysim.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CityController {
    private CityModel city;
    private CityView view;

    public CityController(CityModel city, CityView view) {
        this.city = city;
        this.view = view;
        attachActionListeners();
    }

    private void attachActionListeners() {
        view.getGenerateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // update the model
                city = new CityModel(view.getWidthInput(), view.getHeightInput());
                // update the view by passing the new model to it
                view.update(city);
            }
        });
    }
}
