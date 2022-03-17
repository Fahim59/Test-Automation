package com.Base;

import io.github.bonigarcia.wdm.*;
import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

import java.io.*;

public class BaseClass {

    public static WebDriver driver;

    public static void FirefoxLaunch(){WebDriverManager.firefoxdriver().setup();driver = new FirefoxDriver();}

    public static void FirefoxQuit(){driver.quit();}

    public static void OpenWebsite(String Url){driver.get(Url);}

    public static void Screenshot(String methodName) throws IOException {

        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(image,new File("./Screenshot/" + methodName + "-" + ".jpg"));
        }
        catch(IOException ex){
            ex.getMessage();
        }
    }
}
