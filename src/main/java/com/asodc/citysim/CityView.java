package com.asodc.citysim;

import javax.swing.*;
import java.awt.*;

class CityView extends JPanel {
    private int viewWidth;
    private int viewHeight;
    private Image business;
    private Image grass;
    private Image municipal;
    private Image park;
    private Image residential;
    private Image river;
    private Image riverBank;
    private Image road;
    private Image sidewalk;
    private Image trainLine;
    private Image tramLine;
    private final City city;
    private final int TILESIZE = 12;

    public CityView(City city) {
        this.city = city;
        this.viewWidth = city.getWidth() * TILESIZE;
        this.viewHeight = city.getHeight() * TILESIZE;
        loadImages();
        createView();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawTiles(graphics);
    }

    private void loadImages() {
        ImageIcon businessIcon = new ImageIcon("src/main/resources/tiles/business.png");
        business = businessIcon.getImage();
        ImageIcon grassIcon = new ImageIcon("src/main/resources/tiles/grass.png");
        grass = grassIcon.getImage();
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

    private void drawTiles(Graphics graphics) {
        for(int y = 0; y < city.getHeight(); y++) {
            for(int x = 0; x < city.getWidth(); x++) {
                Image tempImage = road;
                switch (city.getTile(x, y).getTileType()) {
                    case BUSINESS:
                        tempImage = business;
                        break;
                    case GRASS:
                        tempImage = grass;
                        break;
                    case MUNICIPAL:
                        tempImage = municipal;
                        break;
                    case PARK:
                        tempImage = park;
                        break;
                    case RESIDENTIAL:
                        tempImage = residential;
                        break;
                    case RIVER:
                        tempImage = river;
                        break;
                    case RIVERBANK:
                        tempImage = riverBank;
                        break;
                    case ROAD:
                        tempImage = road;
                        break;
                    case SIDEWALK:
                        tempImage = sidewalk;
                        break;
                    case TRAINLINE:
                        tempImage = trainLine;
                        break;
                    case TRAMLINE:
                        tempImage = tramLine;
                        break;
                }
                graphics.drawImage(tempImage, x * TILESIZE, y * TILESIZE, this);
            }
        }
    }

    private void createView() {
        setBackground(Color.PINK);
        setFocusable(true);
        setPreferredSize(new Dimension(viewWidth, viewHeight));
    }
}
