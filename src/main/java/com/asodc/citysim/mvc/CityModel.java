package com.asodc.citysim.mvc;

public class CityModel {
    private int width;
    private int height;
    private Tile[][] tiles;

    public CityModel() {
        this(10, 10);
    }

    public CityModel(int width, int height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
            this.tiles = new Tile[width][height];
            generateCity();
        } else {
            throw new IllegalArgumentException("City dimensions cannot be zero or negative");
        }
    }

    private void generateCity() {
        // currently generates random tiles
        for (int y = 0; y < tiles[1].length; y++) {
            for (int x = 0; x < tiles[0].length; x++) {
                tiles[x][y] = new Tile(TileType.random());
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
