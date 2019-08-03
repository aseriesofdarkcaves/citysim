public class Tile {

    // I'm clinging onto this type of setup rather than inheritance...
    private final TileType type;

    public Tile(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.getType().toString();
    }
}
