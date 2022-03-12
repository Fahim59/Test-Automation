package com.Assignment1;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.*;
import java.util.*;

public class Ass_1 extends BaseClass {

    @BeforeClass
    public static void LaunchBrowser(){
        FirefoxLaunch();
    }

    /*@Test
    public static void Pickaboo_Laptop_Pouch(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.navigate().to("https://www.pickaboo.com/");

        driver.findElement(By.xpath("//*[@id='search']")).sendKeys("Laptop", Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='reject']")));

        WebElement image1 = driver.findElement(By.xpath("//img[@alt='Beacon 15.6 Inch Laptop Pouch Bag - Black']"));
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
    }*/

    @Test
    public static void Test1(){
        driver.navigate().to("https://www.tripadvisor.in/Search?q=Club%20Mahindra&searchSessionId=1910A3F89365689AF73219E4748E0FBC1647023503362ssid&searchNearby=false&sid=24C79F5A74714301A67A055315C01A9F1647023526038&blockRedirect=true");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String oldTab = driver.getWindowHandle();

        driver.findElement(By.xpath("//span[text()='Club Mahindra Madikeri, Coorg']")).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.close();

        driver.switchTo().window(newTab.get(0)); // Switch to new tab
        driver.findElement(By.cssSelector(".badtN > a:nth-child(1)")).click();
    }

    @AfterClass
    public static void QuitBrowser(){
        //FirefoxQuit();
    }
}
