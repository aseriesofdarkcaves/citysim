import javax.swing.*;
import java.awt.*;


public class Map extends JPanel {

    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    private Image street;

    public Map() {
        loadImages();
        createBoard();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTiles(g,null);
    }

    private void loadImages() {
        ImageIcon streetIcon = new ImageIcon("src/main/resources/tiles/street.png");
        street = streetIcon.getImage();
    }


    private void drawTiles(Graphics g, CityState state) {
        g.drawImage(street, 100, 100, this);
    }

    private void createBoard() {
        setBackground(Color.pink);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }



}
