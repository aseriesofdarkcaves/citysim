package com.asodc.citysim;

import java.util.HashMap;
import java.util.Random;

class Tile {
    private final TileType type;
    private static HashMap<TileType, Tile> instancedTiles = new HashMap<>();

    protected Tile(TileType type) {
        this.type = type;
    }

    TileType getTileType() {
        return type;
    }

    static Tile create(TileType type) {
        if (instancedTiles.containsKey(type))
            return instancedTiles.get(type);
        else {
            Tile tile = new Tile(type);
            instancedTiles.put(type, tile);
            return tile;
        }
    }

    @Override
    public String toString() {
        return this.getTileType().toString();
    }
}

enum TileType {
    BUSINESS,
    GRASS,
    MUNICIPAL,
    PARK,
    RESIDENTIAL,
    RIVER,
    RIVERBANK,
    ROAD,
    SIDEWALK,
    TRAINLINE,
    TRAMLINE;

    private static final Random RANDOM = new Random();

    static TileType random() {
        return values()[RANDOM.nextInt(values().length)];
    }
}

