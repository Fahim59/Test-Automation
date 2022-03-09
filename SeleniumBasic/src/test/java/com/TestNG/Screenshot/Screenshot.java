package com.TestNG.Screenshot;

import com.Base.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

@Listeners(SS_Listeners.class)
public class Screenshot extends BaseClass {

    @BeforeClass
    public static void LaunchBrowser(){
        FirefoxLaunch();
        //OpenWebsite("https://the-internet.herokuapp.com/login");
        OpenWebsite("https://google.com/");
    }

    @Test
    public static void Test1(){
        driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/a/svg"));
    }

    @Test
    public static void Test2(){
        driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/a/svg"));
    }

    @AfterClass
    public static void QuitBrowser(){
        FirefoxQuit();
    }
}
