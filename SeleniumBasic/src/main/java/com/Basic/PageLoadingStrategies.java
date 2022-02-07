package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class PageLoadingStrategies extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        FirefoxLaunch();

        //Normal();
        //Eager();
        //None();

        OpenWebsite("https://www.daraz.com.bd/");
        SmallWait();
        FirefoxQuit();
    }
    public static void Normal(){
        //Waits for the entire page to be loaded

        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    }

    public static void Eager(){
        //Waits until the initial HTML document has been completely loaded and parsed
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
    }

    public static void None(){
        //Waits only the initial page is downloaded
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
    }
}
