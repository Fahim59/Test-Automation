package com.TestNG.Assertion;

import com.Base.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class Assertion extends BaseClass {

    @BeforeClass
    public static void LaunchBrowser(){
        FirefoxLaunch();
        OpenWebsite("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public static void Logo(){
        WebElement logo = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/img"));
        Assert.assertTrue(logo.isDisplayed(),"Logo not Present"); //If returns true then pass or fails
        //Assert.assertFalse(logo.isDisplayed(),"Logo Present");
    }

    @Test
    public static void Title(){
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM",title,"Title not Matched");
    }

    @AfterClass
    public static void QuitBrowser(){
        FirefoxQuit();
    }
}
