package com.asodc.citysim.mvc;

import javax.swing.*;
import java.awt.*;

public class MapView extends JPanel {
    private CityModel city;
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

    public MapView() {}

    public MapView(CityModel city) {
        this.city = city;
        initImages();
    }

    private void initImages() {
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

    @Override
    public void paintComponent(Graphics graphics) {
        // TODO: find out how this works
        super.paintComponent(graphics);
        drawMap(graphics);
    }

    private void drawMap(Graphics graphics) {
        graphics.drawImage(business, 0, 0, this);
    }
}
