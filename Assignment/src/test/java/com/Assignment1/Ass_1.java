package com.Assignment1;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.*;

public class Ass_1 extends BaseClass {

    @BeforeClass
    public static void LaunchBrowser(){
        FirefoxLaunch();
    }

    @Test
    public static void Pickaboo_Laptop_Pouch(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.navigate().to("https://www.pickaboo.com/");

        driver.findElement(By.xpath("//*[@id='search']")).sendKeys("Laptop", Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='reject']")));

        WebElement image1 = driver.findElement(By.xpath("//img[@alt='Beacon 15.6 Inch Laptop Pouch Bag - Black']"));
        //WebElement image1 = driver.findElement(By.xpath("//img[@alt='Beacon 14.6 Inch Laptop Pouch Bag - Black']"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click()", image1);

        String element1 = driver.findElement(By.id("product-price-5208")).getText();

        String[] array1 = element1.split("৳", 2);
        int price1 = Integer.parseInt(array1[1]);

        //----------------------------------------------------------------------------//

        WebElement image2 = driver.findElement(By.xpath("//img[@alt='Beacon 14.6 Inch Laptop Pouch Bag - Black']"));
        JavascriptExecutor js2 = (JavascriptExecutor)driver;
        js2.executeScript("arguments[0].click()", image2);

        String element2 = driver.findElement(By.id("product-price-5208")).getText();

        String[] array2 = element2.split("৳", 2);
        int price2 = Integer.parseInt(array2[1]);

        if(price1 == price2){
            System.out.println("Both price are equal");
        }
        else if(price1 > price2){
            System.out.println("Beacon 15.6 Inch Laptop Pouch Bag's price is more");
        }
        else{
            System.out.println("Beacon 14.6 Inch Laptop Pouch Bag's price is more");
        }
    }

    @AfterClass
    public static void QuitBrowser(){
        FirefoxQuit();
    }
}
