package page.actions;

import constants.ApplicationConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.objects.GenericActionsObjects;
import helper.SeleniumCommands;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static constants.ApplicationConstants.*;
import static helper.SeleniumCommands.browserNavigation;
import static helper.SeleniumCommands.waitForElementToBeVisible;

public class GeneralActions {
    public static void navigateToUrl() throws Exception {
        //ApplicationConstants.PORTAL = "Partner Shopify";
        browserNavigation(ApplicationConstants.login_URL);
        Thread.sleep(3000);

    }
    public static void navigateToUrl(String url) throws Exception {
        //ApplicationConstants.PORTAL = "Partner Shopify";
        browserNavigation(url);
        Thread.sleep(3000);

    }
    public static void click_button(String button) throws Exception {

        if (button.equals("Continue with email")) {
            waitForElementToBeVisible(GenericActionsObjects.CONTINUE_BUTTON(button));
            driver.findElement(GenericActionsObjects.CONTINUE_BUTTON(button)).click();
        } else {
            waitForElementToBeVisible(GenericActionsObjects.BUTTON(button));
            driver.findElement(GenericActionsObjects.BUTTON(button)).click();
        }
    }
    public static void click_hyperlink(String name) throws Exception {
        SeleniumCommands.clickElementJavascript(GenericActionsObjects.hyperLink(name));
    }

    public static void click_pumper_action(String offer_name, String action) throws Exception {
        SeleniumCommands.clickElementJavascript(GenericActionsObjects.action_Btn(offer_name, action));
    }

    public static void switchFrame(String button) throws Exception {

        if (button.equals("Pumper Dashboard")) {
            SeleniumCommands.switchToIFrame("app-iframe");
        }
    }

    public static void fill_input_field(String input)
    {
        By inputXpath = By.xpath("//input[@id='account_" +input+ "']");
        switch (input)
        {
            case "email":
                wait.until(ExpectedConditions.elementToBeClickable(inputXpath));
                driver.findElement(inputXpath).sendKeys("theboxx420@yahoo.com");
                break;

            case "password":
                wait.until(ExpectedConditions.elementToBeClickable(inputXpath));
                driver.findElement(inputXpath).sendKeys("Proveway@123");
                break;

            default: System.out.println("No Input field found");
        }
    }

}
