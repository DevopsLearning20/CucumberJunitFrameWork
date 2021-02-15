package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /***
     * this method is used to initialization of the driver method
     * @param browser = name of the browser
     * @return current instance of the driver
     */
    public WebDriver init_driver(String browser)
    {
        System.out.println("browser value is :" +browser);

        if(browser.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }else if(browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }else if(browser.equalsIgnoreCase("ie"))
        {
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new InternetExplorerDriver());
        }
        else {
            System.out.println("Please pass the correct browser value");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    /***
     * This is used to get the driver with ThreadLocal
     * @return thread of current driver
     */
    public static synchronized WebDriver getDriver()
    {
        return tlDriver.get();
    }
}
