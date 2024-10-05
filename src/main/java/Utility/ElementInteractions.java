package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementInteractions {
    public void clickElement(WebElement element){
        try {
            // Click on the element
            element.click();
        } catch (Exception e) {
            Actions actions = new Actions(DriverUtils.getDriver());
            actions.moveToElement(element).click().build().perform();
            e.printStackTrace();
        }
    }

    public void sendDataToFiels(WebElement element, String data) {
        try {
// Send data to the field
            element.sendKeys(data);
        } catch (Exception e) {
            Actions actions = new Actions(DriverUtils.getDriver());
            actions.moveToElement(element).sendKeys(data).build().perform();
            e.printStackTrace();
        }
    }
}
