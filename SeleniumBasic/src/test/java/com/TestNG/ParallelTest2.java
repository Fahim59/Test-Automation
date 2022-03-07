package com.TestNG;

import com.Base.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class ParallelTest2 extends BaseClass {

    @Test
    public static void LoginTest(){
        FirefoxLaunch();
        OpenWebsite("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @AfterMethod
    public static void QuitBrowser(){
        FirefoxQuit();
    }
}
