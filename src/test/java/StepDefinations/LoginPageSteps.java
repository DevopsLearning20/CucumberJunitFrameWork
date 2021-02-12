package StepDefinations;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class LoginPageSteps {

    private static String title;
    private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void userIsOnLoginPage() {

        DriverFactory.getDriver().get("https://marketplace.mitigram.com/Account/Login?ReturnUrl=%2f");
    }

    @When("user gets the title of the page")
    public void userGetsTheTitleOfThePage() {
        title = loginpage.getLoginPageTitle();
        System.out.println("Login Page Title: " + title);
    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expectedTile) {
        System.out.println("expectedTile = "+expectedTile);
        System.out.println("Title =" +title);

        Assert.assertTrue(title.contains(expectedTile));
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {

        Assert.assertTrue(loginpage.isForgotPwdLinkExist());

    }



}
