package com.TestNG;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.testng.*;
import org.testng.annotations.*;

public class Parameters {
    public static WebDriver driver;

    @BeforeClass
    @org.testng.annotations.Parameters({"browser","url"})
    public static void LaunchBrowser(String browser, String url){

        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else{
            System.out.println("Enter Correct Browser Name");
        }

        driver.get(url);
    }

    @Test
    public static void Title(){
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM",title,"Title not Matched");
    }

    @AfterClass
    public static void QuitBrowser(){
        driver.quit();
    }
}
