public class Tile {

    private final TileType type;

    public Tile(TileType type) {
        this.type = type;
    }

    public TileType getTileType() {
        return type;
    }

    @Override
    public String toString() {
        return this.getTileType().toString();
    }
}
