package com.asodc.citysim.mvc;

import com.asodc.citysim.utilities.Numerics;

public class CityModel {
    private int width;
    private int height;

    public CityModel() {
        // initial state at program start is a city with zero size
        this(0, 0);
    }

    public CityModel(int width, int height) {
        if(Numerics.isPositive(width) && Numerics.isPositive(height)) {
            this.width = width;
            this.height = height;
        } else {
            throw new IllegalArgumentException("City dimensions cannot be negative");
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
