package com.Basic;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class FIleDownload {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");

        FirefoxProfile profile = new FirefoxProfile();

        profile.setPreference("browser.helperApps.neverAsk.openFile",false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/jpeg;application/pdf;text/plain;application/text;text/xml;application/xml");
        profile.setPreference("browser.download.manager.showWhenStarting",false);

        FirefoxOptions option = new FirefoxOptions();
        option.setProfile(profile);

        WebDriver driver = new FirefoxDriver(option);

        driver.navigate().to("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[@href='download/some-file.txt']")).click();
    }
}
