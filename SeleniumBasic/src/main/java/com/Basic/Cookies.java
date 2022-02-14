package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;

import java.util.*;

public class Cookies extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        FirefoxLaunch();
        OpenWebsite("https://www.amazon.in/");

        HandlingCookies();

        SmallWait();
        FirefoxQuit();
    }

    public static void HandlingCookies(){
        Set<Cookie> cookie = driver.manage().getCookies();
        System.out.println(cookie.size());

        for(Cookie cookies1 : cookie){
            System.out.println(cookies1.getName() + ":" +cookies1.getValue());
        }

        System.out.println(driver.manage().getCookieNamed("session-id-time"));
        System.out.println("//--------------------//");
        //------------------------Adding New Cookies-------------------------------//

        Cookie cookies1 = new Cookie("mycookie","12345678");
        driver.manage().addCookie(cookies1);

        cookie = driver.manage().getCookies();
        System.out.println("New Cookies :" +cookie.size());

        for(Cookie cookies2 : cookie){
            System.out.println(cookies1.getName() + ":" +cookies2.getValue());
        }
        System.out.println("//--------------------//");
        //-----------------------Deleting a Cookie--------------------------------//

        driver.manage().deleteCookie(cookies1);

        cookie = driver.manage().getCookies();
        System.out.println("After Deleting, New Cookies :" +cookie.size());

        for(Cookie cookies2 : cookie){
            System.out.println(cookies1.getName() + ":" +cookies2.getValue());
        }
        System.out.println("//--------------------//");
        //-----------------------Deleting all Cookies--------------------------------//

        driver.manage().deleteAllCookies();

        cookie = driver.manage().getCookies();
        System.out.println("After Deleting, New Cookies :" +cookie.size());
    }
}
