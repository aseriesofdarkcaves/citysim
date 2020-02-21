package com.asodc.citysim;

public class CityModel {
    private Tile[][] tiles;
    private GenerationStrategy strategy;

    public CityModel() {}

    public CityModel(GenerationStrategy strategy) {
        this.strategy = strategy;
        this.tiles = strategy.getTiles();
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getWidth() {
        return strategy.getWidth();
    }

    public int getHeight() {
        return strategy.getHeight();
    }
}
