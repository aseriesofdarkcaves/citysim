import javax.swing.*;
import java.awt.*;


public class Map extends JPanel {

    private final int WIDTH = 640;
    private final int HEIGHT = 480;
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

    public Map(City city) {
        loadImages();
        createBoard();
        this.city = city;
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
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }



}
