package com.asodc.citysim.old;

import java.util.HashMap;

class TileFactory {
    private static HashMap<TileType, Tile> instancedTiles = new HashMap<>();

    private TileFactory() {}

    static Tile create(TileType type) {
        if (instancedTiles.containsKey(type))
            return instancedTiles.get(type);
        else {
            Tile tile = new Tile(type);
            instancedTiles.put(type, tile);
            return tile;
        }
    }
}
