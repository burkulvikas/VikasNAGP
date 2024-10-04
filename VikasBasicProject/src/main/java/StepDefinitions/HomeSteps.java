package StepDefinitions;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.HomePage;


public class HomeSteps {
    HomePage homePage = new HomePage();
    @When("^I am on the site$")
    public void i_am_on_the_site()  {
        homePage.navigateTosite();
    }


    @Then("^Validate user is on home page$")
    public void validateUserIsOnHomePage() {
        homePage.validateUserIsOnHomePage();
    }


    @Then("^Validate the site url$")
    public void validateTheSiteUrl() {
        homePage.validateTheSiteUrl();
    }

    @Then("^Validate the site header$")
    public void validateTheSiteHeader() {
        homePage.validateTheSiteHeader();
    }
}
