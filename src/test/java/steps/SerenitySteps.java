package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex on 10/04/2017.
 */

public class SerenitySteps {

    @Steps
    NavigatingUser navigation;

    @Managed
    WebDriver driver;


    @Given("^I navigate to the following webpage \"([^\"]*)\"$")
    public void iNavigateToTheFollowingWebpage(final String address) throws Throwable {
        navigation.isOnTheHomePage(address);
    }

    @And("^I navigate to the category \"([^\"]*)\"$")
    public void iNavigateToTheCategory(String category) throws Throwable {
        navigation.navigatesToTheCategory(category);
    }

    @Then("^I should see the pageTitle containing \"([^\"]*)\"$")
    public void iShouldSeeThePageTitleContaining(String expectedTitle) throws Throwable {
        navigation.shouldSeeThePageTitleContaining(expectedTitle);
    }

}
