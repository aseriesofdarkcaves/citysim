import java.io.*;

class CityBuilder {

    CityBuilder(String cityFile) {
        ClassLoader classLoader = getClass().getClassLoader();

        try (BufferedReader reader = new BufferedReader(new FileReader(cityFile))) {
            System.out.println(reader.readLine());
            // do shit
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
