package com.qa.util;

import com.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ElementUtils {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ElementUtils.class));
    private WebDriver driver;

    public ElementUtils(WebDriver driver)
    {
        this.driver = driver;
    }

    /***
     * This method is used to check the broken link on the page
     * @throws IOException
     */

    public void brokenLinkFinder() throws IOException {
        List<WebElement> listOfTheLink = driver.findElements(By.tagName("a"));

        LOGGER.info("Size of the link on webPage ==========> " + listOfTheLink.size());
        //System.out.println("Size of the link on webPage ==========> " + listOfTheLink.size());

        // add the imag tag as well in the list
        listOfTheLink.addAll(driver.findElements(By.tagName("img")));
        System.out.println("After add Imeges total count of links are  ==========> " + listOfTheLink.size());

        // check the valid Linke with are having href attribute only
        List<WebElement> activeLinks = new ArrayList<WebElement>();
        for (int i = 0; i < listOfTheLink.size(); i++) {

            if (listOfTheLink.get(i).getAttribute("href") != null && (!listOfTheLink.get(i).getAttribute("href").contains("javascript")))

                activeLinks.add(listOfTheLink.get(i));

        }
        System.out.println("List of the vlaid Links  ==========> " + activeLinks.size());

        //Check the URL of valid connection using httpConnection API

        for (int j = 0; j < activeLinks.size(); j++) {
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            int respose = connection.getResponseCode();
            connection.disconnect();
            LOGGER.info(activeLinks.get(j).getAttribute("href") + "===========>" + respose);
            //System.out.println(activeLinks.get(j).getAttribute("href") + "===========>" + respose);
        }

        }

    /***
     * To upload the document using getfile method which return the absolute path
     * @param locator
     */

    public void uploadFile(By locator)
    {
        WebElement uploadEle = driver.findElement(locator);
        uploadEle.sendKeys(getFile());
    }

    String getFile() {
        return new File(Constant.FILEPATH).getAbsolutePath();
    }
}
