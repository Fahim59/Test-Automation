package com.TestNG;

import com.Base.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class ParallelTest1 extends BaseClass {

    @Test
    public static void Logo(){
        FirefoxLaunch();
        OpenWebsite("https://www.aiub.edu/");

        WebElement logo = driver.findElement(By.cssSelector(".logo > img:nth-child(1)"));
        Assert.assertTrue(logo.isDisplayed(),"Logo not Present");
    }

    @Test
    public static void Title(){
        FirefoxLaunch();
        OpenWebsite("https://www.aiub.edu/");

        String title = driver.getTitle();
        Assert.assertEquals("Home | AIUB",title,"Title not Matched");
    }

    @AfterMethod
    public static void QuitBrowser(){FirefoxQuit();}
}
