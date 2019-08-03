import java.util.HashMap;

public class RandomTileFactory {

    private static HashMap<TileType, Tile> tiles = new HashMap<>();

    public static Tile create() {
        Tile tile;
        TileType tileType = TileType.random();
        if (tiles.containsKey(tileType))
            return tiles.get(tileType);
        else {
            tile = new Tile(tileType);
            tiles.put(tileType, tile);
            return tile;
        }
    }
}
