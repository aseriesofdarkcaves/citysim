package com.asodc.citysim.utilities;

public class Numerics {
    private Numerics() {}

    public static boolean isNegative(int value) {
        return value < 0;
    }

    public static boolean isPositive(int value) {
        // 0 technically isn't positive, but in this context it is
        return value >= 0;
    }
}
