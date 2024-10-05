package StepDefinitions;

import Utility.DriverUtils;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario " + scenario.getName() + " is " + scenario.getStatus());
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                System.out.println("Scenario Failed :-> " + scenario.getName());
                File sourcePath = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
                FileUtils.copyFile(sourcePath, destinationPath);
                Reporter.addScreenCaptureFromPath(new File("screenshots/" + screenshotName + ".png").toString());
//                Reporter.addScreenCast(destinationPath.toString());
            } catch (IOException e) {
                System.out.println("Exception Occurred : " + e);
            }
        }

    }
}
