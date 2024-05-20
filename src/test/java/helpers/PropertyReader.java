package helpers;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static Properties constantsProperties = new Properties();

    public static void readPropertyFile(String filepath) {
        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(filepath)) {

            if (input == null) {
                System.out.println("Sorry, unable to find testData.properties");
                return;
            }
            constantsProperties.load(input);

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
