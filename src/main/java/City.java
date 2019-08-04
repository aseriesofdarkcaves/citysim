import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class City {

    private String name;
    private int width;
    private int height;
    private Tile[][] tiles;
    private List<Business> businesses = new ArrayList<>();
    private final CityType type;
    private static final int DEFAULT_WIDTH = 3;
    private static final int DEFAULT_HEIGHT = 3;
    private static final CityType DEFAULT_TYPE = CityType.GUI_CITY;

    public City(String name) {
        this(name, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public City(String name, int width, int height) {
        this(name, width, height, DEFAULT_TYPE);
    }

    public City(String name, int width, int height, CityType type) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.type = type;
        tiles = new Tile[this.width][this.height];
        tiles = CityGenerator.create(type, this.width, this.height);
    }

    private void generateRandomCity() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
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
        // horizontalRoads = random between 1 and width/2
        // verticalRoads = random between 1 and height/2
        // choose a random x coordinate and draw verticalRoads number of roads vertically
        // choose a random y coordinate and draw horizontalRoads number of roads horizontally
        // RULE: roads cannot be drawn in immediately adjacent axes
        // fill empty tiles with business tiles

        Random horizontalRandom = new Random();
        Random verticalRandom = new Random();

        int horizontalRoads = horizontalRandom.nextInt(height / 4) + (height / 4);
        int verticalRoads = verticalRandom.nextInt(width / 4) + (width / 4);

        for (int x = 0; x < height; x++) {
            int drawRoad = horizontalRandom.nextInt(2);
            if (drawRoad == 1 && horizontalRoads != 0) {
                for (int y = 0; y < width; y++) {
                    // draw horizontal road
                    tiles[x][y] = TileFactory.create(TileType.ROAD);
                }
                horizontalRoads--;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
