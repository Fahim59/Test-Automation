package com.Assignment2;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.*;
import org.testng.annotations.*;

import java.time.*;
import java.util.*;

public class Ass_2 extends BaseClass {

    @BeforeClass
    public static void LaunchBrowser(){
        FirefoxLaunch();
    }

    @Test
    public static void Trip_Advisor() throws InterruptedException {
        Actions actions = new Actions(driver);

        driver.navigate().to("https://www.tripadvisor.in/");

        driver.findElement(By.cssSelector(".fRhqZ > form:nth-child(2) > input:nth-child(1)")).sendKeys("Club Mahindra", Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String oldTab = driver.getWindowHandle();

        driver.findElement(By.xpath("//span[text()='Club Mahindra Madikeri, Coorg']")).click();
        //-------------------------------------------------------------------------------------//
        ArrayList<String> child = new ArrayList<String>(driver.getWindowHandles());
        child.remove(oldTab);
        driver.switchTo().window(child.get(0)); //Switch to new tab

        driver.findElement(By.cssSelector(".badtN > a:nth-child(1)")).click();
        //-------------------------------------------------------------------------------------//
        ArrayList<String> child1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(child1.get(2));
        //-------------------------------------------------------------------------------------//
        WebElement review = driver.findElement(By.cssSelector("#bubble_rating"));
        actions.moveToElement(review).click().build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("#ReviewTitle")).sendKeys("Service");
        driver.findElement(By.xpath("//textarea[@id='ReviewText']")).sendKeys("Nice");
        //--------------------------------------------------------------------------------------//

        try{
            if(driver.findElement(By.xpath("//div[@id='DQ_RATINGS']")).isDisplayed()){
                System.out.println("Section Available");
            }
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Section not available");
        }
        //------------------------------------------------------------------------------------//

        driver.findElement(By.xpath("//input[@id='noFraud']")).click();
        driver.findElement(By.xpath("//div[@id='SUBMIT']"));
    }

    /*@Test(priority = 1)
    public static void Test1(){
        driver.navigate().to("https://www.tripadvisor.in/");

        driver.findElement(By.cssSelector(".fRhqZ > form:nth-child(2) > input:nth-child(1)")).sendKeys("Club Mahindra", Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//span[text()='Club Mahindra Madikeri, Coorg']")).click();
    }

    @Test(priority = 2)
    public static void Test2(){
        driver.navigate().to("https://www.tripadvisor.in/Hotel_Review-g641714-d1156207-Reviews-Club_Mahindra_Madikeri_Coorg-Madikeri_Kodagu_Coorg_Karnataka.html");

        driver.findElement(By.cssSelector(".badtN > a:nth-child(1)")).click();
    }

    @Test(priority = 3)
    public static void Test3(){
        Actions actions = new Actions(driver);
        driver.navigate().to("https://www.tripadvisor.in/UserReviewEdit-g641714-d1156207-Club_Mahindra_Madikeri_Coorg-Madikeri_Kodagu_Coorg_Karnataka.html");

        WebElement review = driver.findElement(By.cssSelector("#bubble_rating"));
        actions.moveToElement(review).click().build().perform();
    }

    @Test(priority = 4)
    public static void Test4(){

        driver.navigate().to("https://www.tripadvisor.in/UserReviewEdit-g641714-d1156207-Club_Mahindra_Madikeri_Coorg-Madikeri_Kodagu_Coorg_Karnataka.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("#ReviewTitle")).sendKeys("Service");
        driver.findElement(By.xpath("//textarea[@id='ReviewText']")).sendKeys("Nice");
        //--------------------------------------------------------------------------------------//

        try{
            if(driver.findElement(By.xpath("//div[@id='DQ_RATINGS']")).isDisplayed()){
                System.out.println("Section Available");
            }
        }
        catch (NoSuchElementException exception){
            System.out.println("Section not available");
        }
        //------------------------------------------------------------------------------------//

        driver.findElement(By.xpath("//input[@id='noFraud']")).click();
        driver.findElement(By.xpath("//div[@id='SUBMIT']"));
    }*/

    @AfterClass
    public static void QuitBrowser(){
        //FirefoxQuit();
    }
}
