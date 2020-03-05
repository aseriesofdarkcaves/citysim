package com.asodc.citysim;

import java.util.List;

class CityModel {
    private Tile[][] tiles;
    private GenerationStrategy strategy;

    CityModel() {}

    CityModel(GenerationStrategy strategy) {
        this.strategy = strategy;
        this.tiles = strategy.getTiles();
    }

    Tile[][] getTiles() {
        return tiles;
    }

    List<Business> getBusinesses() {
        // TODO: determine if this is a good idea or not
        return strategy.businesses;
    }

    int getWidth() {
        return strategy.getWidth();
    }

    int getHeight() {
        return strategy.getHeight();
    }
}
