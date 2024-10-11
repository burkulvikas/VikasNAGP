package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {

   WebDriver driver;
   public HomePage(WebDriver driver){
       this.driver=driver;
   }
    public void navigateTosite(){
        System.out.println("Navigating to site");
        driver.get("https://demoqa.com/");
    }

    public void validateUserIsOnHomePage() {
        System.out.println("Validating user is on home page");
        String title = driver.getTitle();
        System.out.println("Title of the page is: "+title);
        Assert.assertEquals(title, "DEMOQA", "User is not on home page");
    }

    public void validateTheSiteUrl() {
        String url = driver.getCurrentUrl();
        System.out.println("URL of the page is: "+url);
        Assert.assertEquals(url, "https://demoqa.com/", "URL is not correct");
    }

    public void validateTheSiteHeader() {
        WebElement header = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
        Assert.assertTrue(header.isDisplayed(), "Header is not displayed");
    }
}
