package com.stepDefinition.EditCustomerStepDefinition;

import com.Base.*;
import io.cucumber.java.en.*;
import org.apache.log4j.*;
import org.junit.*;
import org.openqa.selenium.*;

import java.time.*;
import java.util.logging.Logger;

public class EditCustomerSteps extends BaseClass {

    @Given("User launch Firefox browser")
    public void user_launch_firefox_browser() {
        FirefoxLaunch();
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        OpenWebsite(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {

        WebElement txtEmail = driver.findElement(By.id("Email"));
        txtEmail.clear();
        txtEmail.sendKeys(email);

        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    @When("Click on Login")
    public void click_on_login() {

        driver.findElement(By.cssSelector(".button-1")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
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

    @Then("User finds Customer and clicks on Edit button")
    public void user_finds_customer_and_clicks_on_edit_button() {

        int tr = driver.findElements(By.xpath("/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[2]")).size();
        for(int i = 1; i<= tr; i++){

            String name = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();

            if(name.equalsIgnoreCase("James Pan")){
                driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[7]")).click();
                break;
            }
        }
    }

    @Then("Edit the Customer info")
    public void edit_the_customer_info() {

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.clear();
        lastName.sendKeys("Pan");
    }

    @Then("Clicks on Save Button")
    public void clicks_on_save_button() {

        driver.findElement(By.xpath("//button[@class='btn btn-primary' and @name='save']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Then("Checks the Edited info of the customer")
    public void checks_the_edited_info_of_the_customer() {

        if(driver.getPageSource().contains("The customer has been updated successfully.")){
            System.out.println("Info Undated");
        }
        else{
            Assert.fail();
        }
    }

    @Then("Close the browser")
    public void close_the_browser() {
        FirefoxQuit();
    }
}
