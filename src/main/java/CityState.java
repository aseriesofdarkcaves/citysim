import java.util.ArrayList;
import java.util.Random;

class CityState {
    private static Tile[][] tiles;
    private static ArrayList<Business> businesses = new ArrayList<>();

    private CityState(int width, int height) {
        tiles = new Tile[width][height];
    }

    static CityState createInitialState(City city) {
        // TODO fix this, it doesn't feel correct
        CityState state = new CityState(city.getWidth(), city.getHeight());
        switch (city.getType()) {
            case GUI_CITY:
                generateGuiCity();
                break;
            case RANDOM_CITY:
                generateRandomCity();
                break;
        }
        return state;
    }

    private static void generateGuiCity() {
        // horizontalRoads = random between 1 and width/2
        // verticalRoads = random between 1 and height/2
        // choose a random x coordinate and draw verticalRoads number of roads vertically
        // choose a random y coordinate and draw horizontalRoads number of roads horizontally
        // RULE: roads cannot be drawn in immediately adjacent axes
        // fill empty tiles with business tiles

        Random horizontalRandom = new Random();
        Random verticalRandom = new Random();

        int horizontalRoads = horizontalRandom.nextInt(tiles[0].length / 4) + (tiles[0].length / 4);
        int verticalRoads = verticalRandom.nextInt(tiles[1].length / 4) + (tiles[1].length / 4);

        for (int x = 0; x < tiles[0].length; x++) {
            int drawRoad = horizontalRandom.nextInt(2);
            if (drawRoad == 1 && horizontalRoads != 0) {
                for (int y = 0; y < tiles[1].length; y++) {
                    // draw horizontal road
                    tiles[x][y] = TileFactory.create(TileType.ROAD);
                }
                horizontalRoads--;
            }
        }
        // TODO draw vertical roads
    }

    private static void generateRandomCity() {
        for (int y = 0; y < tiles[1].length; y++) {
            for (int x = 0; x < tiles[0].length; x++) {
                Tile currentTile = TileFactory.create(TileType.random());
                if (currentTile.getTileType() == TileType.BUSINESS) {
                    businesses.add(new Business());
                }
                tiles[x][y] = currentTile;
            }
        }
    }

    Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    Tile[][] getTiles() {
        return tiles;
    }

    ArrayList<Business> getBusinesses() {
        return businesses;
    }
}
