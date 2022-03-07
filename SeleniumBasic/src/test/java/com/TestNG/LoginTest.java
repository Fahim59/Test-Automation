//description--priority--enable;disable--dependency--always run

package com.TestNG;

import com.Base.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import java.util.*;

public class LoginTest extends BaseClass {

    @BeforeClass //Executes only once before all test methods
    public static void LaunchBrowser(){
        FirefoxLaunch();
        OpenWebsite("https://www.rediff.com/");
    }

    @BeforeMethod //Executes before every test methods
    public static void BeforeMethod(){
        System.out.println("Website Successfully Launched");
    }
    //------------------------------------------------------------------------------------//

    @Test(description = "This is for valid scenario", priority = 1)
    public static void Login(){
        String Password = "QXBwaXVtMTIzQA==";
        String decode = new String (Base64.getDecoder().decode(Password.getBytes()));

        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login1")).sendKeys("seleniumt@rediffmail.com");
        driver.findElement(By.id("password")).sendKeys(decode);
        driver.findElement(By.name("proceed")).click();
    }

    @Test(priority = 2)
    public static void Logout(){driver.findElement(By.linkText("Logout")).click();}

    @Test(description = "This is for skip scenario", priority = 3, enabled = false)
    public static void Test3(){
        System.out.println("Executed Test 3");
    }

    @Test(dependsOnMethods = {"Logout"}, alwaysRun = true)
    public static void Test4(){
        System.out.println("Executed Test 4");
    }

    //------------------------------------------------------------------------------------//
    @AfterMethod //Executes after every test methods
    public static void AfterMethod(){System.out.println("Screenshot Successfully Taken");}

    @AfterClass //Executes only once after all test methods
    public static void QuitBrowser(){
        FirefoxQuit();
    }
    //------------------------------------------------------------------------------------//
}
