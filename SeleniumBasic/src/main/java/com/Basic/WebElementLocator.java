package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.*;

import java.util.*;

public class WebElementLocator extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        FirefoxLaunch();
        OpenWebsite("https://www.google.com/");

        //Locators();
        RelativeLocator();

        SmallWait();
        FirefoxQuit();
    }
    public static void Locators(){
        driver.findElement(By.name("q"));
        driver.findElement(By.id("gb"));
        driver.findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(2)"));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));

        driver.navigate().to("https://demo.guru99.com/V4/index.php");

        driver.findElement(By.linkText("here"));
        driver.findElement(By.partialLinkText("here"));

        driver.navigate().to("https://trytestingthis.netlify.app/");

        List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));
        for(WebElement element : options){
            System.out.println(element.getText());
        }
    }

    public static void RelativeLocator(){
        //above, below, near, toLeftOF, toRightOf
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

        WebElement btn = driver.findElement(By.id("btnLogin"));

        driver.findElement(RelativeLocator.with(By.tagName("input")).above(btn)).sendKeys("Fahim");
    }
}
