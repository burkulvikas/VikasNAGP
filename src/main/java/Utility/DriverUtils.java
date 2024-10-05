package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverUtils {
    static Properties prop;
    static WebDriver driver;


    public DriverUtils() {
        System.setProperty("webdriver.chrome.driver", getProperty("driverPath"));
//         WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model
//        options.addArguments("--headless"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }



    public static WebDriver getDriver() {
        return driver;
    }

    public static String getProperty(String property) {
        String configFile = "./src/main/resources/data.properties";
        try {
            FileInputStream stream=new FileInputStream(configFile);
            prop = new Properties();
            prop.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);}

            return prop.getProperty(property);

    }

}
