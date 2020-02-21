package com.asodc.citysim.old;

class City {
    private String name;
    private int width;
    private int height;
    private final CityType type;
    private CityState state;
    private String cityFile;
    private static final CityType DEFAULT_TYPE = CityType.RANDOM;

    City(String name, int width, int height) {
        this(name, width, height, DEFAULT_TYPE);
    }

    City(String name, int width, int height, CityType type) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.type = type;
        setInitialState(this);
    }

    // TODO we can't know the width and height before parsing the file
    City(String name, int width, int height, String cityFile) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.type = CityType.CUSTOM;
        this.cityFile = cityFile;
        setInitialState(this);
    }

    private void setInitialState(City city) {
        this.state = CityState.createInitialState(city);
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

    String getCityFile() {
        return cityFile;
    }
}
