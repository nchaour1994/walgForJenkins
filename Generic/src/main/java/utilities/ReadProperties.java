package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
     static Properties properties;
    public static Properties getProperties(){
        properties=new Properties();
        try {
            FileInputStream file=new FileInputStream("..\\walg\\src\\test\\resources\\config.properties");
            properties.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    return properties;
    }
}
