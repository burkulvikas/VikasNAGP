package testClasses;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObject.HomePage;

import java.io.File;
import java.io.IOException;


public class TestFile implements ITestListener {
    WebDriver driver;
    @BeforeClass
    public void initilizeDriver(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--headless=old"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        this.driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void onTestFailure(ITestResult result) {
        System.out.println("Scenario " + result.getMethod().getMethodName()+ " is " + result.getStatus());
        if (!result.isSuccess()) {
            String screenshotName = result.getMethod().getMethodName().replaceAll(" ", "_");
            try {
                System.out.println("Scenario Failed :-> " + result.getMethod().getMethodName());
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
                FileUtils.copyFile(sourcePath, destinationPath);
            } catch (IOException e) {
                System.out.println("Exception Occurred : " + e);
            }
        }
    }

    @Test(priority = 0)
    public void validateUserIsOnHomePage(){
        HomePage homePage=new HomePage(driver);
        homePage.navigateTosite();
        homePage.validateUserIsOnHomePage();
    }
    @Test(priority = 1)
    public void validatePageHeader(){
        HomePage homePage=new HomePage(driver);
        homePage.validateTheSiteHeader();
    }
    @Test(priority = 3)
    public void validatePageURL(){
        HomePage homePage=new HomePage(driver);
        homePage.validateTheSiteUrl();
    }


    @AfterClass
    public void closeBrowser(){driver.quit();}
}
