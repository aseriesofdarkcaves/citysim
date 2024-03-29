package com.asodc.citysim;

abstract class CityGenerationStrategy {
    private int width;
    private int height;

    private CityGenerationStrategy() {
    }

    protected CityGenerationStrategy(int width, int height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            throw new IllegalArgumentException("City dimensions cannot be zero or negative");
        }
    }

    abstract Tile[][] getTiles();

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}
