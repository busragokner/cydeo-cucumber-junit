package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPages;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    OrderPages orderPages = new OrderPages();
    ViewAllOrdersPage viewAllOrdersPage =new ViewAllOrdersPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        //Getting the page using the URL from configuration.properties
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
        webTableLoginPage.login();
        basePage.order.click();


    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(orderPages.productDropdown);
        select.selectByVisibleText(string);

    }
    @And("user enters quantity {int}")
    public void user_enters_quantity(int arg0) {

        //orderPages.inputQuantity.clear();

        orderPages.inputQuantity.sendKeys(Keys.BACK_SPACE);

        orderPages.inputQuantity.sendKeys(arg0+"");
        //orderPages.inputQuantity.sendKeys(String.valueOf(arg0));

    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {

        orderPages.inputName.sendKeys(string);

    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPages.inputStreet.sendKeys(string);

    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {

        orderPages.inputCity.sendKeys(string);

    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPages.inputState.sendKeys(string);

    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPages.inputZip.sendKeys(string);

    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {
        BrowserUtils.clickRadioButton(orderPages.creditCardType, expectedCardType);

    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {

        orderPages.cardNoInput.sendKeys(string);


    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {

        orderPages.cardExpInput.sendKeys(string);

    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPages.processOrderButton.click();

    }
    @Then("user should see {string} in first roe of the web table")
    public void user_should_see_in_first_roe_of_the_web_table(String expectedName) {

       String actualName = viewAllOrdersPage.newCustomerCell.getText();
       Assert.assertEquals(expectedName,actualName);


    }

}
