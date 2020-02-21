package com.asodc.citysim.old;

import java.util.Random;

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

    // TODO extract constant and random method to some form of superclass
    private static final Random RANDOM = new Random();

    static TileType random() {
        return values()[RANDOM.nextInt(values().length)];
    }
}
