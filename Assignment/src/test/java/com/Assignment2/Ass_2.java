package com.Assignment2;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.*;
import java.util.*;

public class Ass_2 extends BaseClass {

    @BeforeClass
    public static void LaunchBrowser(){
        FirefoxLaunch();
    }

    @Test
    public static void Trip_Advisor() throws InterruptedException {

        driver.navigate().to("https://www.tripadvisor.in/");

        driver.findElement(By.cssSelector(".fRhqZ > form:nth-child(2) > input:nth-child(1)")).sendKeys("Club Mahindra", Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String oldTab = driver.getWindowHandle();

        driver.findElement(By.xpath("//span[text()='Club Mahindra Madikeri, Coorg']")).click();
        //-------------------------------------------------------------------------------------//
        ArrayList<String> child = new ArrayList<String>(driver.getWindowHandles());
        child.remove(oldTab);
        driver.switchTo().window(child.get(0)); //Switch to new tab

        driver.findElement(By.cssSelector(".badtN > a:nth-child(1)")).click();
        //-------------------------------------------------------------------------------------//
        ArrayList<String> child1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(child1.get(2));
        //-------------------------------------------------------------------------------------//

        new Actions(driver).moveToElement(new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#bubble_rating"))), 50, 0).click().build().perform();
        //new Actions(driver).moveToElement(new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='bubble_rating']"))), 50, 0).click().build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("#ReviewTitle")).sendKeys("Pleasant and relaxing trip");
        driver.findElement(By.xpath("//textarea[@id='ReviewText']")).sendKeys("Well organized and maintained property with lots of activities for everyone. Bishwanath and Aditya took care of the rooms and housekeeping in a great manner. Appreciate the politeness and humble nature of all the staff members.");
        //--------------------------------------------------------------------------------------//
        driver.findElement(By.xpath("//div[@class='c-cell jfy_cloud tag content category-familyYoungChildren']")).click();
        //--------------------------------------------------------------------------------------//
        WebElement drop = driver.findElement(By.xpath("//select[@id='trip_date_month_year']"));
        Select select = new Select(drop);

        List<WebElement> options = select.getOptions();
        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase("January 2022")){
                option.click();
            }
        }
        //------------------------------------------------------------------------------------//
        new Actions(driver).moveToElement(new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='qid12_bubbles']"))), 40, 0).click().build().perform(); //4 star

        new Actions(driver).moveToElement(new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='qid190_bubbles']"))), 40, 0).click().build().perform(); //5 star

        new Actions(driver).moveToElement(new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='qid14_bubbles']"))), 40, 0).click().build().perform(); //5 star
        //------------------------------------------------------------------------------------//
        driver.findElement(By.xpath("//div[@data-tagid='-51841']")).click();

        driver.findElement(By.xpath("//input[@id='noFraud']")).click();
        driver.findElement(By.xpath("//div[@id='SUBMIT']"));
    }

    @AfterClass
    public static void QuitBrowser(){
        //FirefoxQuit();
    }
}
