package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //By Locater

    private By emailId = By.cssSelector("#Email");
    private By password = By.cssSelector("#Password");
    private By signInButton = By.cssSelector("button[id='loginBtn'] span[class='login']");
    private By forgotPwdLink = By.linkText("Forgot your password?");
    private By contactusLink = By.linkText("Click here to contact us");

    //2. Constructor of the page class

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;

    }

    //3. Page action :: feature of the page

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }

   /* public AccountsPage doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountsPage(driver);
    }*/

}
