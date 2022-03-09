package com.Base;

import com.google.zxing.NotFoundException;
import io.github.bonigarcia.wdm.*;
import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

import java.awt.*;
import java.io.*;

public class BaseClass {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException, NotFoundException, AWTException {}

    public static void FirefoxLaunch(){WebDriverManager.firefoxdriver().setup();driver = new FirefoxDriver();}
    //public static void FirefoxLaunch(){System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");}

    public static void FirefoxClose(){driver.close();}

    public static void FirefoxQuit(){driver.quit();}

    public static void SmallWait() throws InterruptedException {Thread.sleep(3000);}

    public static void OpenWebsite(String Url){driver.get(Url);}

    public static void Screenshot(String methodName) throws IOException {

        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            //FileUtils.copyFile(image,new File("./Screenshot/image.png"));
            FileUtils.copyFile(image,new File("./Screenshot/" + methodName + "-" + ".jpg"));
        }
        catch(IOException ex){
            ex.getMessage();
        }
    }
}
