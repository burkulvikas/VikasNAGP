package testRunner;


import Utility.DriverUtils;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;




@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        plugin = { "pretty","html:target/site/cucumber-pretty","json:target/cucumber1.json",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        glue = {"StepDefinitions","Hooks"},
        dryRun = false,
        tags={"@test","~@ignore"})


public class Runner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setUp(){
        DriverUtils driverUtils=new DriverUtils();
    }


    @AfterClass
    public void reportGeneration(){
        String reportConfigPath = "src/test/resources/reportConfig/extent-config.xml";
        Reporter.loadXMLConfig(new File(reportConfigPath));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows");
        Reporter.setSystemInfo("Selenium", "4.0.0");
        Reporter.setSystemInfo("Maven", "3.8.6");
        Reporter.setSystemInfo("Java Version", "1.8");
        DriverUtils.getDriver().quit();
    }
}
