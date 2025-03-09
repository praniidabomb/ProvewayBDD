package stepDefinitions;

import constants.ApplicationConstants;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.actions.GeneralActions;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static constants.ApplicationConstants.driver;
import static constants.ApplicationConstants.wait;
import static page.actions.GeneralActions.fill_input_field;

public class DeleteOffer_StepDefinition {


    @Given("user is on login page")
    public void user_navigates_to_login_page(){
        driver.get(ApplicationConstants.login_URL);
        driver.manage().window().maximize();
        System.out.println("User on Login page");

    }
    @When("user enters username and password")
    public void user_enters_username_and_password() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - user enters username and password");
        //System.out.println(driver);

        fill_input_field("email");

        GeneralActions.click_button("Continue with email");

        fill_input_field("password");
    }
    @And("^user clicks on \"([^\"]*)\" button$")
    public void clicks_on_login_button(String button) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - user clicks on login button" + button);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GeneralActions.click_button(button);
    }
    @Then("^user is logged in and selects the \"([^\"]*)\"")
    public void user_is_navigated_to_the_home_page(String hyperlink) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        if(driver.getTitle().equals("Shopify account profile"))
        {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Failed to login. Try Again with correct credentials");
            //driver.quit();
        }
        System.out.println("Inside Step - user is navigated to the home page");
        GeneralActions.click_hyperlink(hyperlink);

    }
    @And("^On a new tab choose an Account select the \"([^\"]*)\" account$")
    public void on_a_new_tab_select_account(String accName) throws Exception {
        //Tab switch

        // Get all window handles
        GeneralActions.navigateToUrl("Next tab");

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Cloathing asa']")));
//        driver.findElement(By.xpath( "//div[text()= 'Cloathing asa']")).click();

        GeneralActions.click_hyperlink(accName);

        // Optionally, wait for the next page to load
//        try {
//            Thread.sleep(3000);  // Adjust as needed
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.findElement(By.xpath("//a//*[text() = 'Cloathing Proveway']")).click();


    }
    @Then("^user selects the \"([^\"]*)\" store and is navigated to the Store Home page$")
    public void user_selects_store_navigated_to_homepage(String storeName) throws Exception {
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//*[text() = 'Cloathing Proveway']")));
//        String store_name = "Cloathing Proveway";
//        driver.findElement(By.xpath("//a//*[text() = '"+store_name+"']")).click();
//        Thread.sleep(10000);
        GeneralActions.click_hyperlink(storeName);


        if(driver.getTitle().contains(storeName))
        {
            System.out.println("Store Login successful");
        } else {
            System.out.println("Failed to login. Try Again with correct Store Name");
            //driver.quit();
        }
    }

    @When("user clicks on {string} tool")
    public void userClicksOnTool(String arg0) throws Exception {
        GeneralActions.click_hyperlink(arg0);

    }

    @And("user is on the {string}")
    public void userIsOnThe(String arg0) throws Exception {
        Thread.sleep(3000);
        GeneralActions.switchFrame(arg0);

        //Thread.sleep(10000);  // Adjust as needed

//        driver.findElement(By.xpath("//span[text() = 'Bundle_Offer_S7D1']/parent::span/parent::td/parent::tr//div[@class = 'clone-btn']")).click();
//        Thread.sleep(10000);
//        //driver.findElement(By.xpath("//span[text()='Bundle_Offer_S7D1']/../following::td[2]//div[@class = 'badge-toggle-wrapper']/span[2]")).click();
//        driver.findElement(By.xpath("//span[text()='Bundle_Offer_S7D1 clone']/../following::td[4]//div[@class = 'delete-btn']")).click();


    }

    @Then("user can {string} the {string} Offer")
    public void user_perform_actions_to_a_offer(String arg0, String arg1) throws Exception {
        if(arg0.equals("Clone"))
        {
            GeneralActions.click_pumper_action(arg1,"clone");
        }
        else if(arg0.equals("Delete")) {
            GeneralActions.click_pumper_action(arg1,"delete");
            //GeneralActions.click_button("//*[text() = 'Would you like to delete the offer?']/../following::button//span[text() = 'Yes']");
            GeneralActions.click_button("Yes");
        }
    }
}
