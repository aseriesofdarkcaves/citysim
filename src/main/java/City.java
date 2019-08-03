import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class City {

    private String cityName;
    private int cityWidth;
    private int cityHeight;
    private Tile[][] tiles;
    private List<Business> businesses = new ArrayList<>();
    private final CityType cityType;
    private static final int DEFAULT_CITY_WIDTH = 3;
    private static final int DEFAULT_CITY_HEIGHT = 3;
    private static final CityType DEFAULT_CITY_TYPE = CityType.GUI_CITY;

    public City(String cityName) {
        this(cityName, DEFAULT_CITY_WIDTH, DEFAULT_CITY_HEIGHT);
    }

    public City(String cityName, int cityWidth, int cityHeight) {
        this(cityName, cityWidth, cityHeight, DEFAULT_CITY_TYPE);
    }

    public City(String cityName, int cityWidth, int cityHeight, CityType cityType) {
        this.cityName = cityName;
        this.cityWidth = cityWidth;
        this.cityHeight = cityHeight;
        this.cityType = cityType;
        tiles = new Tile[this.cityWidth][this.cityHeight];
        tiles = CityGenerator.create(cityType, this.cityWidth, this.cityHeight);
    }

    private void generateRandomCity() {
        for (int y = 0; y < cityHeight; y++) {
            for (int x = 0; x < cityWidth; x++) {
                Tile currentTile = TileFactory.create(TileType.random());
                if (currentTile.getType() == TileType.BUSINESS) {
                    businesses.add(new Business());
                }
                tiles[x][y] = currentTile;
            }
        }
    }

    private void generateGridCity() {
        // TODO grid of roads with sprinkling of businesses
    }

    private void generateGuiCity() {
        // horizontalRoads = random between 1 and cityWidth/2
        // verticalRoads = random between 1 and cityHeight/2
        // choose a random x coordinate and draw verticalRoads number of roads vertically
        // choose a random y coordinate and draw horizontalRoads number of roads horizontally
        // RULE: roads cannot be drawn in immediately adjacent axes
        // fill empty tiles with business tiles

        Random horizontalRandom = new Random();
        Random verticalRandom = new Random();

        int horizontalRoads = horizontalRandom.nextInt(cityHeight / 4) + (cityHeight / 4);
        int verticalRoads = verticalRandom.nextInt(cityWidth / 4) + (cityWidth / 4);

        for (int x = 0; x < cityHeight; x++) {
            int drawRoad = horizontalRandom.nextInt(2);
            if (drawRoad == 1 && horizontalRoads != 0) {
                for (int y = 0; y < cityWidth; y++) {
                    // draw horizontal road
                    tiles[x][y] = TileFactory.create(TileType.ROAD);
                }
                horizontalRoads--;
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
