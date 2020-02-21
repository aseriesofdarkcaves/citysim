package com.asodc.citysim;

import javax.swing.*;
import java.awt.*;

public class CityMap extends JPanel {
    private int mapWidth;
    private int mapHeight;
    private CityModel cityModel;
    private Image business;
    private Image grass;
    private Image invalid;
    private Image municipal;
    private Image park;
    private Image residential;
    private Image river;
    private Image riverBank;
    private Image road;
    private Image sidewalk;
    private Image trainLine;
    private Image tramLine;
    private boolean isModelInitialised = false;
    private final int TILE_PIXEL_SIZE = 12;

    public CityMap() {}

    public CityMap(CityModel cityModel) {
        this.mapWidth = cityModel.getWidth() * TILE_PIXEL_SIZE;
        this.mapHeight = cityModel.getHeight() * TILE_PIXEL_SIZE;
        this.cityModel = cityModel;
        isModelInitialised = true;
        // apparently this method is important for updates?
        setPreferredSize(new Dimension(mapWidth, mapHeight));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        initImages();
    }

    private void initImages() {
        ImageIcon businessIcon = new ImageIcon("src/main/resources/tiles/business.png");
        business = businessIcon.getImage();
        ImageIcon grassIcon = new ImageIcon("src/main/resources/tiles/grass.png");
        grass = grassIcon.getImage();
        ImageIcon invalidIcon = new ImageIcon("src/main/resources/tiles/invalid.png");
        invalid = invalidIcon.getImage();
        ImageIcon municipalIcon = new ImageIcon("src/main/resources/tiles/municipal.png");
        municipal = municipalIcon.getImage();
        ImageIcon parkIcon = new ImageIcon("src/main/resources/tiles/park.png");
        park = parkIcon.getImage();
        ImageIcon residentialIcon = new ImageIcon("src/main/resources/tiles/residential.png");
        residential = residentialIcon.getImage();
        ImageIcon riverIcon = new ImageIcon("src/main/resources/tiles/river.png");
        river = riverIcon.getImage();
        ImageIcon riverBankIcon = new ImageIcon("src/main/resources/tiles/riverBank.png");
        riverBank = riverBankIcon.getImage();
        ImageIcon roadIcon = new ImageIcon("src/main/resources/tiles/road.png");
        road = roadIcon.getImage();
        ImageIcon sidewaklIcon = new ImageIcon("src/main/resources/tiles/sidewalk.png");
        sidewalk = sidewaklIcon.getImage();
        ImageIcon trainLineIcon = new ImageIcon("src/main/resources/tiles/trainLine.png");
        trainLine = trainLineIcon.getImage();
        ImageIcon tramLineIcon = new ImageIcon("src/main/resources/tiles/tramLine.png");
        tramLine = tramLineIcon.getImage();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (isModelInitialised) {
            paintTiles(graphics);
        }
    }

    private void paintTiles(Graphics graphics) {
        Tile[][] tiles = cityModel.getTiles();
        // note how the getting the length of 2D arrays work
        for (int y = 0; y < tiles[0].length; y++) {
            for (int x = 0; x < tiles.length; x++) {
                TileType currentTileType = tiles[x][y].getTileType();
                graphics.drawImage(getImage(currentTileType), x * TILE_PIXEL_SIZE, y * TILE_PIXEL_SIZE, this);
            }
        }
    }

    private Image getImage(TileType tileType) {
        switch (tileType) {
            case BUSINESS:
                return business;
            case GRASS:
                return grass;
            case MUNICIPAL:
                return municipal;
            case PARK:
                return park;
            case RESIDENTIAL:
                return residential;
            case RIVER:
                return river;
            case RIVERBANK:
                return riverBank;
            case ROAD:
                return road;
            case SIDEWALK:
                return sidewalk;
            case TRAINLINE:
                return trainLine;
            case TRAMLINE:
                return tramLine;
        }
        return invalid;
    }
}
