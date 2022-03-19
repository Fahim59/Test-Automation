package com.stepDefinition;

import com.Base.*;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;

import java.time.*;

public class SearchCustomerSteps extends BaseClass {

    @Given("User launch's Firefox browser")
    public void user_launch_s_firefox_browser() {
        FirefoxLaunch();
    }

    @When("User open URL {string}")
    public void user_open_url(String url) {
        OpenWebsite(url);
    }

    @When("User enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String email, String password) {
        WebElement txtEmail = driver.findElement(By.id("Email"));
        txtEmail.clear();
        txtEmail.sendKeys(email);

        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    @When("Click Login")
    public void click_login() {
        driver.findElement(By.cssSelector(".button-1")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Then("Page title should {string}")
    public void page_title_should(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assert.fail();
        }
        else{
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User click on Customer menu")
    public void user_click_on_customer_menu() {
        WebElement menu = driver.findElement(By.xpath("//p[text()=' Customers']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",menu);
    }

    @When("User click on Customer menu item")
    public void user_click_on_customer_menu_item() {
        driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']"));
    }

    @When("User types email as {string}")
    public void user_types_email_as(String email) {

        driver.findElement(By.id("SearchEmail")).sendKeys(email);
    }

    @Then("Click on Search button")
    public void click_on_search_button() {
        driver.findElement(By.id("search-customers")).click();
    }

    @Then("User can see email {string} in the table")
    public void user_can_see_email_in_the_table(String email) {

        int tr = driver.findElements(By.xpath("/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[2]")).size();
        for(int i = 1; i<= tr; i++){

            String email_id = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();

            Assert.assertEquals(email,email_id);
        }
    }

    @When("User types name as {string}")
    public void user_types_name_as(String name) {

        driver.findElement(By.id("SearchFirstName")).sendKeys(name);
    }

    @Then("User can see name {string} in the table")
    public void user_can_see_name_in_the_table(String name) {

        int tr = driver.findElements(By.xpath("/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[2]")).size();
        for(int i = 1; i<= tr; i++){

            String firstname = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
            String[] arrOfStr = firstname.split(" ", 2);

            Assert.assertEquals(name,arrOfStr[0]);
        }
    }

    @Then("Closes browser")
    public void closes_browser() {
        FirefoxQuit();
    }
}
