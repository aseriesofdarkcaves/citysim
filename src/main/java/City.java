import java.util.ArrayList;
import java.util.List;

public class City {

    private String cityName;
    private int cityWidth;
    private int cityHeight;
    private Tile[][] tiles;
    private List<Business> businesses = new ArrayList<>();
    private static final int DEFAULT_CITY_WIDTH = 3;
    private static final int DEFAULT_CITY_HEIGHT = 3;

    public City(String cityName) {
        this(cityName, DEFAULT_CITY_WIDTH, DEFAULT_CITY_HEIGHT);
    }

    public City(String cityName, int cityWidth, int cityHeight) {
        this.cityName = cityName;
        this.cityWidth = cityWidth;
        this.cityHeight = cityHeight;
        generateTiles();
    }

    private void generateTiles() {
        // dumb random generation algorithm
        tiles = new Tile[cityWidth][cityHeight];
        for (int y = 0; y < cityHeight; y++) {
            for (int x = 0; x < cityWidth; x++) {
                Tile currentTile = RandomTileFactory.create();
                if (currentTile.getType() == TileType.BUSINESS) {
                    businesses.add(new Business());
                }
                tiles[x][y] = currentTile;
            }
        }
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityWidth() {
        return cityWidth;
    }

    public int getCityHeight() {
        return cityHeight;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
