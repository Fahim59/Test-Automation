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
        //RelativeLocator();
        LocateElements();

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

        List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]")); //For multiple elements
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

    public static void LocateElements(){
        //Element from Element

        /*WebElement form = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form"));
        form.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);*/
        //----------------------------------------------------------------------//
        //Active Elements

        /*driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);

        String title = driver.switchTo().activeElement().getAttribute("title");
        System.out.println(title);*/
        //-----------------------------------------------------------------------//
        //Get tag name, css value, text

        /*WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("Selenium");

        System.out.println(searchbox.getText());
        System.out.println(searchbox.getCssValue("font"));
        System.out.println(searchbox.getTagName());*/
        //-----------------------------------------------------------------------//
        //Find enable/disable elements

        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> option = driver.findElements(By.tagName("input"));
        for(WebElement element : option){
            System.out.println(element.isEnabled());
            System.out.println(element.isSelected());
        }
    }
}
