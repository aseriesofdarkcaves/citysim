import java.io.*;

class CityBuilder {

    CityBuilder(String cityFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cityFile))) {
            reader.readLine();
            // do shit
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
