package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import java.io.*;
import java.net.*;
import java.time.*;
import java.util.*;

public class Mix extends BaseClass {
    public static void main(String[] args) throws InterruptedException, IOException {
        FirefoxLaunch();

        //BrokenLink();
        //BrokenImage();
        //ContextMenu();

        SmallWait();
        FirefoxQuit();
    }
    public static void BrokenLink() throws InterruptedException, IOException {
        /*A broken link is a link on a web page that no longer works because of one the following reasons
        --> the url is improper
        --> the destination website removed the linked webpage(404 error)
        --> the destination website is permanently removed or no longer exists
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demo.guru99.com/V4/index.php");

        Thread.sleep(5000);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        for(int i = 0; i < links.size(); i++){
            WebElement element = links.get(i);
            String url = element.getAttribute("href");

            URL link = new URL(url);

            HttpURLConnection httpCom = (HttpURLConnection) link.openConnection();
            Thread.sleep(3000);

            httpCom.connect();

            int code = httpCom.getResponseCode();

            if(code >= 400){
                System.out.println(url +" - "+ " is broken");
            }
            else {
                System.out.println(url +" - "+ " is not broken");
            }
        }
    }

    public static void BrokenImage(){
        driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
        //---------------------------------------------------------------------------//
        //Single Image
        WebElement image = driver.findElement(By.xpath("/html/body/div[2]/div/div/img[1]"));

        if (image.getAttribute("naturalWidth").equals("0")) {
            System.out.println(image.getAttribute("outerHTML") + " is broken.");
        }
        else{
            System.out.println(image.getAttribute("outerHTML") + " is not broken.");
        }
        //------------------------------------------------------------------------------------//
        //Multiple Images
        /*List <WebElement>  images = driver.findElements(By.tagName("img"));
        System.out.println(images.size());

        for(WebElement img :images){
            if (img.getAttribute("naturalWidth").equals("0")) {
                System.out.println(img.getAttribute("outerHTML") + " is broken.");
            }
            else{
                System.out.println(img.getAttribute("outerHTML") + " is not broken.");
            }
        }*/
    }

    public static void ContextMenu(){
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);

        WebElement rightClickBtn  = driver.findElement(By.id("hot-spot"));
        actions.contextClick(rightClickBtn).perform();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
}
