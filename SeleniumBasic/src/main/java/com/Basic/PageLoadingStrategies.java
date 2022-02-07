package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class PageLoadingStrategies extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        FirefoxLaunch();
        OpenWebsite("https://www.daraz.com.bd/");

        Normal();

        SmallWait();
        FirefoxQuit();
    }
    public static void Normal(){
        //Waits for the entire page to be loaded
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    }
}
