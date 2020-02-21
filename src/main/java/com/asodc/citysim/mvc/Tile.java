package com.asodc.citysim.mvc;

import java.util.Random;

public class Tile {
    private final TileType type;

    Tile(TileType type) {
        this.type = type;
    }

    TileType getTileType() {
        return type;
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

