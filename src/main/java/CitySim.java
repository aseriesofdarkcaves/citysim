import javax.swing.*;

public class CitySim {

    private static final String cityName = "New Temperance";
    private static final int cityHeight = 20;
    private static final int cityWidth = 20;
    private static City city;

    public static void main(String... args) {

        System.out.printf("Generating %s with %d tiles...%n%n", cityName, cityWidth * cityHeight);
        long startTime = System.currentTimeMillis();
        city = new City(cityName, cityWidth, cityHeight);
        long totalProcessingTime = System.currentTimeMillis() - startTime;

        displayCityTiles();
        System.out.printf("%nTime taken to generate %s: %dms%n", cityName, totalProcessingTime);
    }

    private static void displayCityTiles() {

        // TODO clean this shit up
        JFrame frame = new JFrame();
        frame.setBounds(0, 0,(cityWidth * 100) % 2440, (cityHeight * 50) % 1080);
        //frame.setSize(500, 500);
        frame.setTitle(cityName);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(city.getTiles(), city.getTiles());
        table.setTableHeader(null);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setVisible(true);


//        for (int tileY = 0; tileY < city.getCityHeight(); tileY++) {
//            for (int tileX = 0; tileX < city.getCityWidth(); tileX++) {
//                Tile currentTile = city.getTile(tileX, tileY);
//                if (tileX % city.getCityWidth() == (city.getCityWidth() - 1)) {
//                    System.out.printf("%-20s%n%n%n", currentTile.getType());
//                } else {
//                    System.out.printf("%-20s", currentTile.getType());
//                }
//            }
//        }
    }
}
