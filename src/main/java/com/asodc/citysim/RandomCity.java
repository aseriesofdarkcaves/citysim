package com.asodc.citysim;

class RandomCity extends GenerationStrategy {

    protected RandomCity(int width, int height) {
        super(width, height);
    }

    @Override
    Tile[][] getTiles() {
        Tile[][] tiles = new Tile[this.getWidth()][this.getHeight()];
        for (int y = 0; y < tiles[0].length; y++) {
            for (int x = 0; x < tiles.length; x++) {
                tiles[x][y] = new Tile(TileType.random());
            }
        }
        return tiles;
    }
}
