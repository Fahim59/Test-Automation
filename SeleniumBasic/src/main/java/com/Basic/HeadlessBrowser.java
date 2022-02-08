package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class HeadlessBrowser extends BaseClass {
    public static void main(String[] args) {
        Headless();
    }
    public static void Headless(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");

        FirefoxOptions option = new FirefoxOptions();
        option.setHeadless(true);

        WebDriver driver = new FirefoxDriver(option);
        driver.get("https://www.shohoz.com/bus-tickets");

        System.out.println(driver.getTitle());
    }
}
