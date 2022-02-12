package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class WebTable extends BaseClass{
    public static void main(String[] args) throws InterruptedException {
        FirefoxLaunch();

        //Table();
        TableTest();

        FirefoxQuit();
    }

    public static void Table(){
        //driver.navigate().to("http://www.dhs.state.il.us/accessibility/tests/simple-table-test.html");
        driver.get("file:///C:/Users/Mustafizur%20Rahman/Desktop/Table.html");

        int tr = driver.findElements(By.xpath("/html/body/main/table/tbody/tr")).size();
        System.out.println(tr);

        int th = driver.findElements(By.xpath("/html/body/main/table/thead/tr/th")).size();
        System.out.println(th);

        int td = driver.findElements(By.xpath("/html/body/main/table/tbody/tr[1]/td")).size();
        System.out.println(td);

        for(int l = 1; l<= tr; l++){
            System.out.print(driver.findElement(By.xpath("/html/body/main/table/tbody/tr["+l+"]")).getText() + "\n");
        }
    }

    public static void TableTest() { //Find number of enabled users
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/index.php/admin/viewAdminModule']"))).click();

        int tr = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr")).size();

        int count = 0;

        for(int i = 1; i<= tr; i++){
            String status = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[\"+i+\"]/td[5]")).getText();

            if(status.equals("Enabled")){
                count = count+ 1;
            }
        }
        System.out.println("Number of enabled employees: " +count);
    }
}
