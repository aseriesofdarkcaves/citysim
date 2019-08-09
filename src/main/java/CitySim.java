import javax.swing.*;

class CitySim {
    private static City city;
    private static final String cityName = "New Temperance";
    private static final int cityWidth = 20;
    private static final int cityHeight = 20;
    private static final String cityFile = "src/main/resources/Knobber.ccf";

    public static void main(String... args) {
        long startTime = System.currentTimeMillis();
//        city = new City(cityName, cityWidth, cityHeight);
        city = new City(cityFile, cityFile);
        long totalProcessingTime = System.currentTimeMillis() - startTime;
        System.out.printf("Time taken to generate %s: %dms", cityName, totalProcessingTime);

        displayCityTiles();
    }

    private static void displayCityTiles() {
        // TODO clean this shit up
        JFrame frame = new JFrame();
        frame.setBounds(0, 0,(cityWidth * 100) % 2440, (cityHeight * 50) % 1080);
        frame.setTitle(cityName);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(city.getTiles(), city.getTiles());
        table.setTableHeader(null);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setVisible(true);
    }

    private static void printCityTiles() {
        for (int tileY = 0; tileY < city.getHeight(); tileY++) {
            for (int tileX = 0; tileX < city.getWidth(); tileX++) {
                Tile currentTile = city.getTile(tileX, tileY);
                if (tileX % city.getWidth() == (city.getWidth() - 1)) {
                    System.out.printf("%n%-20s%n%n%n", currentTile.getTileType());
                } else {
                    System.out.printf("%-20s", currentTile.getTileType());
                }
            }
        }
    }
}
