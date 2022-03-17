package com.stepDefinition;

import com.Base.*;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;

import java.time.*;

public class NewCustomerSteps extends BaseClass {

    @Given("User launch the Firefox browser")
    public void user_launch_the_firefox_browser() {
        FirefoxLaunch();
    }
    @When("User opens the URL {string}")
    public void user_opens_the_url(String url) {
        OpenWebsite(url);
    }
    @When("User enters Email {string} and Password {string}")
    public void user_enters_email_and_password(String email, String password) {
        WebElement txtEmail = driver.findElement(By.id("Email"));
        txtEmail.clear();
        txtEmail.sendKeys(email);

        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }
    @When("Click on Login button")
    public void click_on_login_button() {
        driver.findElement(By.cssSelector(".button-1")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Then("Page title should be becomes {string}")
    public void page_title_should_be_becomes(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assert.fail();
        }
        else{
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User clicks on Customer menu")
    public void user_clicks_on_customer_menu() {
        WebElement menu = driver.findElement(By.xpath("//p[text()=' Customers']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",menu);
    }

    @When("User clicks on Customer menu item")
    public void user_clicks_on_customer_menu_item() {
        driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']"));
    }

    @Then("User clicks on Add New button")
    public void user_clicks_on_add_new_button() {
        driver.findElement(By.xpath("//a[@href='/Admin/Customer/Create']")).click();
    }

    @Then("Page title should be like {string}")
    public void page_title_should_be_like(String title) {

        Assert.assertEquals(title, driver.getTitle());
    }

    @When("User enters customer info")
    public void user_enters_customer_info() {
        
    }

    @When("Click on Save button")
    public void click_on_save_button() {
    }

    @Then("User can see confirmation message {string}")
    public void user_can_see_confirmation_message(String string) {
    }

    @Then("Close the browser")
    public void close_the_browser() {
        FirefoxQuit();
    }
}
