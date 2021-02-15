package com.pages;

import com.qa.util.Constant;
import com.qa.util.ElementUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CareersPage {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(CareersPage.class));

    private WebDriver driver;
    private ElementUtils elementUtils;

    // Elements Path of Carrier pages
    private By openPositions = By.xpath("//div[@class='positions']//div[1]");
    private By firstName = By.cssSelector("#first_name");
    private By lastName = By.cssSelector("#last_name");
    private By country = By.cssSelector("#country");
    private By email = By.cssSelector("#email");
    private By phone = By.cssSelector("#phone");
    private By fileUload = By.cssSelector("input[type='file']");
    private By submit = By.cssSelector("button[name='submit']");
    private By emailforOpenPoition = By.linkText("careers@mitigram.com");


    public CareersPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(this.driver);
    }

    //Carrers pages actions

    /***
     * This method return the toatal number of open vacancies
     * @return count of the total vacancies open
     */
    public int getOpenPositionCount() {
        return driver.findElements(openPositions).size() - 2;
    }

    /***
     *  This method will return the name of vacancies
     * @return List<String>  of with vacancies name
     *Link list is
     *
     */
    public List<String> getOpenPositionOnCareerPage() {
        List<String> vacanciesList = new ArrayList<>();
        List<WebElement> openPosition = driver.findElements(openPositions);

        for (WebElement e : openPosition) {
            String text = e.getText();
            vacanciesList.add(text);
        }
        if(vacanciesList.size()>1)
        {
            vacanciesList.remove(0);
            vacanciesList.remove(vacanciesList.size()-1);
        }
        else
        {
            vacanciesList.remove(0);
        }

        return vacanciesList;

    }

    // Validate the email link
    public boolean validateTheContactUSLink() {
        return driver.findElement(emailforOpenPoition).isDisplayed();

    }

    public void validateCareerLink()
    {
        try {
            elementUtils.brokenLinkFinder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     *  Void method used for the future vacancies
     * @param first = First Name
     * @param last = Last Name
     * @param coutry = Country
     * @param eamil = email
     * @param ph = Contact Number
     */
    public void feelThefutureOpening(String first, String last, String coutry, String eamil, String ph) {

        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(country).sendKeys(coutry);
        driver.findElement(email).sendKeys(eamil);
        driver.findElement(phone).sendKeys(ph);
    }

    public void uploadCV() {
        elementUtils.uploadFile(fileUload);
    }

    public void submitApp() {
        driver.findElement(submit).click();
    }

}
