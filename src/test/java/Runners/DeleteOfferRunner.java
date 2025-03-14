package Runners;

import constants.ApplicationConstants;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.ApplicationConstants.driver;
import static constants.ApplicationConstants.wait;

@CucumberOptions(
        features = {"src/test/resources/features/DeleteOffer.feature"}, // Path to your feature files
        glue = {"stepDefinitions"}, // Package of your step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class DeleteOfferRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() throws InterruptedException {
        String browserName = "Chrome";
        launchBrowser(browserName);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ApplicationConstants.driverMap.put(Thread.currentThread().getId(), driver);
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void teardDown()
    {
        //driver.quit();
    }

    public static void launchBrowser(String browserName) {
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                System.out.println("Chrome Done");
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                System.out.println("Firefox Done");
                break;
            case "Internet Explorer":
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Browser not found");
        }
    }
}
