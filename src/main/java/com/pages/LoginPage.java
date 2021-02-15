package com.pages;

import com.qa.util.ElementUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginPage.class));

    private WebDriver driver;
    private ElementUtils elementUtil;

    //By Locater

    private By emailId = By.cssSelector("#Email");
    private By password = By.cssSelector("#Password");
    private By signInButton = By.cssSelector("button[id='loginBtn'] span[class='login']");
    private By forgotPwdLink = By.linkText("Forgot your password?");
    private By contactusLink = By.linkText("Click here to contact us");
    private By error = By.cssSelector("div[class='error']");
    private By appStore = By.cssSelector("img[alt='Download on the App Store']");
    private By googlePlay = By.cssSelector("img[alt='Get it on Google Play']");


    //2. Constructor of the page class
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        elementUtil = new ElementUtils(this.driver);

    }

    //3. Page action :: feature of the page

    public String getLoginPageTitle() {
        LOGGER.info("Validating login page Title");
        return driver.getTitle();
    }


    // validate the forget password link
    public boolean isForgotPwdLinkExist() {
        LOGGER.info("Validating the forget password link");
        return driver.findElement(appStore).isDisplayed();
    }

    // Validate the Google Play Link
    public boolean isGooglePlayIconExits(){
        LOGGER.info("Validating the Google Play Link");
        return driver.findElement(googlePlay).isDisplayed();
    }

    //Validate the Apple store Link
    public boolean isAppStoreIconDisplay() {
        LOGGER.info("Validating the Apple store Link");
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    // Validate the error message is display or not
    public boolean isErrorMessageisDisplayed()
    {
        LOGGER.info("Validating the error message is display");
        return driver.findElement(error).isDisplayed();

    }

    // To validate contact link
    public boolean isContactLinkIsDisplayed()
    {
        LOGGER.info("Validating contact link");
        return driver.findElement(contactusLink).isDisplayed();
    }

    // Enter userName
    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    //Enter the password
    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    //Submit button action
    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }

    // broken link validation method call
    public void checkLoginPageBrokenLinks(){
        try {
            elementUtil.brokenLinkFinder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
