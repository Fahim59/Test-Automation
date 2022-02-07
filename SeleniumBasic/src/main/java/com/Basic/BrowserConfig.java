package com.Basic;

import com.Base.*;
import com.sun.org.apache.bcel.internal.classfile.*;
import org.apache.commons.io.*;
import org.openqa.selenium.*;

import java.io.*;

public class BrowserConfig extends BaseClass {
    public static void main(String[] args) throws InterruptedException, IOException {
        FirefoxLaunch();
        OpenWebsite("https://www.google.com/");

        //BrowserAction();
        //SizeAction();
        Screenshoot();

        SmallWait();
        FirefoxQuit();
    }
    public static void BrowserAction(){
        driver.navigate().to("https://www.github.com/");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        String window = driver.getWindowHandle();
        driver.switchTo().window(window);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public static void SizeAction(){
        //---------------------------------------------------------------------//
        System.out.println(driver.manage().window().getSize().getWidth());
        System.out.println(driver.manage().window().getSize().getHeight());

        driver.manage().window().setSize(new Dimension(800,400));

        System.out.println(driver.manage().window().getSize().getWidth());
        System.out.println(driver.manage().window().getSize().getHeight());
        //--------------------------------------------------------------------//
        Point X = driver.manage().window().getPosition();
        Point Y = driver.manage().window().getPosition();

        System.out.println(X.getX());
        System.out.println(Y.getY());

        driver.manage().window().setPosition(new Point(10,10));

        Point XX = driver.manage().window().getPosition();
        Point YY = driver.manage().window().getPosition();

        System.out.println(XX.getX());
        System.out.println(YY.getY());
        //---------------------------------------------------------------------//
        driver.manage().window().minimize();
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
    }

    public static void Screenshoot() throws IOException {
        WebElement img = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));

        //File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File image = img.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(image,new File("F:/JAVA/ALL CODES/Code/IntelliJ/image.png"));
    }
}
