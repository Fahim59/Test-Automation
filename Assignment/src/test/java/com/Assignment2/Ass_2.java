package com.Assignment2;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.*;

public class Ass_2 extends BaseClass {

    @BeforeClass
    public static void LaunchBrowser(){
        FirefoxLaunch();
    }

    @Test
    public static void Pickaboo_Laptop_Pouch(){
        //*[@id='search']  //*[@class='reject']

        driver.navigate().to("https://www.pickaboo.com/");
    }

    @AfterClass
    public static void QuitBrowser(){
        FirefoxQuit();
    }
}
