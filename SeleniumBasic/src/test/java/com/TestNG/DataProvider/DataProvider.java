package com.TestNG.DataProvider;

import com.Base.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public class DataProvider extends BaseClass {

    @BeforeClass
    public static void LaunchBrowser(){
        FirefoxLaunch();
        OpenWebsite("https://the-internet.herokuapp.com/login");
    }

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviderClass.class)
    public void Login(String id, String pass){

        driver.findElement(By.id("username")).sendKeys(id);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.cssSelector(".radius")).click();

        driver.findElement(By.cssSelector(".icon-2x")).click();
    }

    @AfterClass
    public static void QuitBrowser(){
        FirefoxQuit();
    }
}
