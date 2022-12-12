package com.asodc.citysim;

class CitySimController {
    private CityModel cityModel;
    private CitySimView view;

    CitySimController(CityModel cityModel, CitySimView view) {
        this.cityModel = cityModel;
        this.view = view;
        attachActionListeners();
    }

    private void attachActionListeners() {
        view.getGenerateButton().addActionListener(e -> {
            // TODO: extract GenerationStrategy to allow generation based on user input (combobox etc.)
            cityModel = new CityModel(new RandomCity(view.getWidthInput(), view.getHeightInput()));
            view.update(cityModel);
        });
    }
}
