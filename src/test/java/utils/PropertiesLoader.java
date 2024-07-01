package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                System.out.println("Sorry, unable to find " + fileName);
            }
            properties.load(inputStream);    
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
