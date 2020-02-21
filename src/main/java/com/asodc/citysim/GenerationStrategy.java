package com.asodc.citysim;

public abstract class GenerationStrategy {
    private int width;
    private int height;

    private GenerationStrategy() {}

    protected GenerationStrategy(int width, int height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            throw new IllegalArgumentException("City dimensions cannot be zero or negative");
        }
    }

    public abstract Tile[][] getTiles();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
