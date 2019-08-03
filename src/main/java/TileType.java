import java.util.Random;

public enum TileType {
    ROAD,
    SIDEWALK,
    RIVERBANK,
    RIVER,
    TRAMLINE,
    TRAINLINE,
    GRASS,
    PARK,
    BUSINESS,
    RESIDENTIAL,
    MUNICIPAL;

    // TODO: extract constant and random method to some form of superclass
    private static final Random RANDOM = new Random();

    public static TileType random() {
        return values()[RANDOM.nextInt(values().length)];
    }
}
