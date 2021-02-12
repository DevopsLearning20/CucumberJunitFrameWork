package StepDefinations;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AppHooks {

    private DriverFactory driverManager ;
    private WebDriver driver;
    private ConfigReader config;
    Properties prop;

    @Before(order = 0)
    public void getProperty()
    {
        ConfigReader config = new ConfigReader();
        prop = config.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser()
    {
        String browser = prop.getProperty("browser");
        driverManager = new DriverFactory();
        driver = driverManager.init_driver(browser);

    }

    @After(order = 0)
    public void quitDriver()
    {
        driver.quit();
    }

    @After(order = 1)
    public void takeScreenShot(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            //Take Screen Shot
            String screenShotName = scenario.getName().replaceAll(" ","_");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(sourcePath,"image/png");
        }
    }
}
