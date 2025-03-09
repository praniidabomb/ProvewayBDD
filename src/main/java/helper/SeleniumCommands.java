package helper;
//import com.cucumber.listener.Reporter;

import com.cucumber.listener.Reporter;
import constants.ApplicationConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static constants.ApplicationConstants.driver;

/**
 * This class is used to collate all the generic commands that can be utilized
 * for any application.
 */
public class SeleniumCommands {

    protected int waitTime = 30;
    protected int sheetNo = 0;
    protected String[] testStep;
    protected int nextCommandRow = -1;
    protected static String methodFailureMessage = null;
    public WebDriver driver;
    protected static List<WebDriver> driverList = new ArrayList<WebDriver>();
    int timeOutCounter;
    public int TIMEOUT = 10;

    public static WebDriver getWebDriver() {
        return ApplicationConstants.driverMap.get(Thread.currentThread().getId());
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickElementJavascript(By element) throws Exception {
        try {
            waitForElementToBeVisible(element);
            WebElement welement = getWebDriver().findElement(element);
            JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
            System.out.println("Element Clicked");
            executor.executeScript("arguments[0].click();", welement);
        } catch (Exception e) {
            System.out.println("Element not clicked - " + element + "Exception : " + methodFailureMessage);
            //takeScreenshot();
            throw new Exception("Element not clicked");

        }
    }

    public static void  waitExplicit(int waitTimeinMicroseconds) throws Exception {


        try {
            Thread.sleep(waitTimeinMicroseconds);
        } catch (Exception e) {
            methodFailureMessage = "Unable to wait because of an Exception. Please refer Logs/info.log for more details. " + e.getMessage();


        }

    }
    public static void waitForElementToBeVisible(By element) throws Exception {
        //	setImplicitWait(1, TimeUnit.SECONDS);
        try {
            ApplicationConstants.wait.until(ExpectedConditions.presenceOfElementLocated(element));
            ApplicationConstants.wait.until(ExpectedConditions.elementToBeClickable(element));
            //ApplicationConstants.driver.findElement(element).click();

        } catch (Exception e) {
            waitExplicit(1000);
            //takeScreenshot();
            throw new Exception("Element not found :: " + e.getMessage());

        }
    }
    public static void switchToIFrame(String frame) throws Exception, InterruptedException, IOException {

        try {
            getWebDriver().switchTo().frame(frame);
            System.out.println("Switched to iframe");
        } catch (Exception e) {

            methodFailureMessage = "Cannnot switch to iframe because of exception. Please refer Logs/info.log for more details. "
                    + e.getMessage();
            //takeScreenshot();
            System.out.println(methodFailureMessage);
            Reporter.addStepLog("Unable to switch to iFrame");
            //assertTrue(status.equalsIgnoreCase("Pass"), methodFailureMessage);
        }
    }
    public static void browserNavigation(String url) throws Exception {
        try {
                    if(url.equals("Next tab")) {
                        Set<String> windowHandles = ApplicationConstants.driver.getWindowHandles();
                        List<String> tabs = new ArrayList<>(windowHandles);
                        ApplicationConstants.driver.switchTo().window(tabs.get(1));
                    }
                    else
                        getWebDriver().navigate().to(url);
            }
        catch (Exception e) {

            methodFailureMessage = "Unable to perform action  because of an Exception. Please refer " +
                    "Logs/info.log for more details." + e.getMessage();
            //Reporter.addStepLog("Unable to navigate to browser");
        }
    }
    public void scrollDownToElement(By element, String type) {
        try {
            getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            /*By webEle = getLocator(element);*/
            WebElement elementOnPage = getWebDriver().findElement(element);
            ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", elementOnPage);
        } catch (Exception e) {
            System.out.println("Element not found" + element);
            //takeScreenshot();
            System.out.println(methodFailureMessage);
            Reporter.addStepLog("Unable to scroll down to element");
            //assertTrue(status.equalsIgnoreCase("Pass"), methodFailureMessage);
        }
    }

}
