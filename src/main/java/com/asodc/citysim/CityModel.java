package com.asodc.citysim;

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

    int getWidth() {
        return strategy.getWidth();
    }

    int getHeight() {
        return strategy.getHeight();
    }
}
