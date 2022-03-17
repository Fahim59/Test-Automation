package com.stepDefinition;

import com.Base.*;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;

import java.time.*;

public class LoginSteps extends BaseClass {

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

    @When("User clicks on Logout link")
    public void user_clicks_on_logout_link(){
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }

    @Then("Page title becomes {string}")
    public void page_title_becomes(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @Then("Close browser")
    public void close_browser() {
        FirefoxQuit();
    }
}
