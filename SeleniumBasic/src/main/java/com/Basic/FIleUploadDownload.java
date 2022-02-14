package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FIleUploadDownload extends BaseClass {
    public static void main(String[] args) throws InterruptedException, IOException, AWTException {
        FirefoxLaunch();

        FileUpload();
        //FileDownload();

        SmallWait();
        FirefoxQuit();
    }
    public static void FileUpload() throws InterruptedException, IOException {
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        //------------------------------------------------------------------------------//
        //Using AutoIT
        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"file-upload\"]"))).click().build().perform();

        Runtime.getRuntime().exec("F:\\JAVA\\ALL CODES\\Code\\IntelliJ\\Script.exe"); //File is mentioned in this script

        Thread.sleep(5000);
        //----------------------------------------------------------------------------//
        //Using SendKeys
        /*WebElement button = driver.findElement(By.id("file-upload"));

        button.sendKeys("F:\\JAVA\\ALL CODES\\Code\\IntelliJ\\image.png");*/
        //----------------------------------------------------------------------------//
        driver.findElement(By.id("file-submit")).click();

        if(driver.getPageSource().contains("File Uploaded!")){
            System.out.println("File Uploaded Successfully");
        }
        else{
            System.out.println("File Upload Failed");
        }
    }

    public static void FileDownload() throws AWTException {

        driver.navigate().to("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[@href='download/Image.PNG']")).click();

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
