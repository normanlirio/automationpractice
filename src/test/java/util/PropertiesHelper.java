package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    private FileInputStream fileInputStream;
    private Properties properties;

    public Properties loadProperties() {
        try {
            fileInputStream = new FileInputStream(TestData.RESOURCES);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("File Not Found");
        }
        return properties;
    }
}
