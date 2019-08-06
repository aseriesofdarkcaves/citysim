class City {
    private String name;
    private int width;
    private int height;
    private final CityType type;
    private CityState state;
    private static final CityType DEFAULT_TYPE = CityType.RANDOM_CITY;

    City(String name, int width, int height) {
        this(name, width, height, DEFAULT_TYPE);
    }

    City(String name, int width, int height, CityType type) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.type = type;
        this.state = CityState.createInitialState(this);
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    Tile getTile(int x, int y) {
        return state.getTile(x, y);
    }

    Tile[][] getTiles() {
        return state.getTiles();
    }

    CityType getType() {
        return type;
    }

    CityState getState() {
        return state;
    }
}
