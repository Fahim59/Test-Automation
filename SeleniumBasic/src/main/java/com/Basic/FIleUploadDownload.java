package com.Basic;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

import java.io.*;

public class FIleUploadDownload {
    public static void main(String[] args) throws InterruptedException, IOException {
        FileUpload();
        //FileDownload();
    }
    public static void FileUpload() throws InterruptedException, IOException {
        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("https://www.file.io/");

        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/header/div/div[2]/div[1]/div[2]/label")).click();

        Runtime.getRuntime().exec("F:\\JAVA\\ALL CODES\\Code\\IntelliJ\\Script.exe");

        Thread.sleep(5000);
    }

    public static void FileDownload(){

        FirefoxProfile profile = new FirefoxProfile();

        //profile.setPreference("browser.helperApps.neverAsk.openFile",false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain;application/text;application/pdf");
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir","C:/Users/Mustafizur Rahman/Downloads");
        profile.setPreference("browser.download.folderList", 2);

        FirefoxOptions option = new FirefoxOptions();
        option.setProfile(profile);

        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver(option);

        driver.navigate().to("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[@href='download/some-file.txt']")).click();
    }
}
