package com.asodc.citysim;

import java.util.ArrayList;
import java.util.List;

abstract class GenerationStrategy {
    private int width;
    private int height;
    protected List<Business> businesses = new ArrayList<>();

    private GenerationStrategy() {}

    protected GenerationStrategy(int width, int height) {
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
