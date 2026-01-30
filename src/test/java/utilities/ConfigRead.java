package utilities;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {

    public void readconfigurations() throws IOException {
        FileReader FR = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ConfigFiles\\Config.properties");
        Properties PR = new Properties();
        PR.load(FR);
        System.out.println(PR.getProperty("Browser"));
        System.out.println(PR.getProperty("user"));
        System.out.println(PR.getProperty("password"));
        System.out.println(PR.getProperty(System.getProperty("user.dir")));

    }
}

