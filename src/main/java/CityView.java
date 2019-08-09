import javax.swing.*;
import java.awt.*;


public class CityView extends JPanel {

    private int mapWidth;
    private int mapHeight;
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
        this.mapWidth = city.getWidth() * TILESIZE;
        this.mapHeight = city.getHeight() * TILESIZE;
        loadImages();
        createBoard();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTiles(g);
    }

    private void loadImages() {
        ImageIcon businessIcon = new ImageIcon("src/main/resources/tiles/business.png");
        business = businessIcon.getImage();
        ImageIcon grassIcon = new ImageIcon("src/main/resources/tiles/grass.png");
        grass = grassIcon.getImage();
        ImageIcon residentialIcon = new ImageIcon("src/main/resources/tiles/residential.png");
        residential = residentialIcon.getImage();
        ImageIcon streetIcon = new ImageIcon("src/main/resources/tiles/road.png");
        road = streetIcon.getImage();
    }


    private void drawTiles(Graphics g) {
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
                        break;
                    case PARK:
                        break;
                    case RESIDENTIAL:
                        tempImage = residential;
                        break;
                    case RIVER:
                        break;
                    case RIVERBANK:
                        break;
                    case ROAD:
                        tempImage = road;
                        break;
                    case SIDEWALK:
                        break;
                    case TRAINLINE:
                        break;
                    case TRAMLINE:
                        break;
                }
                g.drawImage(tempImage, x * TILESIZE, y * TILESIZE, this);
            }
        }
    }

    private void createBoard() {
        setBackground(Color.pink);
        setFocusable(true);
        setPreferredSize(new Dimension(mapWidth, mapHeight));
    }



}
