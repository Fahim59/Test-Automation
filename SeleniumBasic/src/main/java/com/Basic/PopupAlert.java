package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;

public class PopupAlert extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        FirefoxLaunch();
        OpenWebsite("https://the-internet.herokuapp.com/javascript_alerts");

        //Alert();
        BasicAuthentication();

        SmallWait();
        FirefoxQuit();
    }
    public static void Alert() throws InterruptedException {
        /*driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/button")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        if(driver.getPageSource().contains("You successfully clicked an alert")){
            System.out.println("Alert Clicked");
        }
        else{
            System.out.println("Alert not Clicked");
        }

        Thread.sleep(5000);*/
        //------------------------------------------------------------------------//
        /*driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/button")).click();

        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.accept(); //Ok
        //alert1.dismiss(); //Cancel

        if(driver.getPageSource().contains("You clicked: Ok")){
            System.out.println("Alert Clicked");
        }
        else{
            System.out.println("Alert not Clicked");
        }

        Thread.sleep(5000);*/
        //------------------------------------------------------------------------//
        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[3]/button")).click();

        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.sendKeys("Javascript Prompt");
        alert2.accept(); //Ok
        //alert1.dismiss(); //Cancel

        if(driver.getPageSource().contains("You entered: Javascript Prompt")){
            System.out.println("Alert Clicked");
        }
        else{
            System.out.println("Alert not Clicked");
        }
    }

    public static void BasicAuthentication(){
        //Formula: protocols://username:password@url
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        if(driver.getPageSource().contains("Congratulations! You must have the proper credentials.")){
            System.out.println("Authentication Succeed");
        }
        else{
            System.out.println("Authentication Failed");
        }
    }
}
