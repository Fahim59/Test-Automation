package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;
import java.util.function.*;

public class Waits extends BaseClass {
    public static void main(String[] args){
        FirefoxLaunch();

        //ImplicitWait();
        //ExplicitWait();
        FluentWait();

        FirefoxQuit();
    }

    public static void ImplicitWait(){
        //It will wait maximum 10 seconds to do the actions, if it finds then it will do the action and quit.
        //By default, settings is 0, Polling frequency 500 ms

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Github" +Keys.ENTER);
    }

    public static void ExplicitWait(){
        //Sometimes the web-driver has to wait for until some condition to be true
        //Polling frequency 500 ms

        driver.navigate().to("https://www.google.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"))).click();
    }

    public static void FluentWait(){
        //Same as Explicit wait
        //Polling frequency can be changed as per need, If element is not found then gives Exception

        driver.navigate().to("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Github" +Keys.ENTER);

        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement element = fwait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement link = driver.findElement(By.linkText("Explore"));

                if(link.isEnabled()){
                    System.out.println("Element Found");
                }
                return link;
            }
        });
        element.click();
    }
}
