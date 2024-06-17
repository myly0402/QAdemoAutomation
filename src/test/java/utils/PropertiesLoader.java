package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static void loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                System.out.println("Sorry, unable to find " + fileName);
                return;
            }
            properties.load(inputStream);
            for (String propertyName : properties.stringPropertyNames()) {
                String propertyValue = properties.getProperty(propertyName);
                System.setProperty(propertyName, propertyValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
