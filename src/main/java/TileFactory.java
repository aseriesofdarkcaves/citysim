import java.util.HashMap;

public class TileFactory {

    private static HashMap<TileType, Tile> tiles = new HashMap<>();

    public static Tile create(TileType tileType) {
        if (tiles.containsKey(tileType))
            return tiles.get(tileType);
        else {
            Tile tile = new Tile(tileType);
            tiles.put(tileType, tile);
            return tile;
        }
    }

}
