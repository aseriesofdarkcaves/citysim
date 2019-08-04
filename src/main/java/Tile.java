class Tile {

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
