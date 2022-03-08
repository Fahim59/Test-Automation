package com.TestNG.ExtentReports;

import com.Base.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public class ExtentReport extends BaseClass {

    @BeforeClass
    public static void LaunchBrowser(){
        FirefoxLaunch();
        OpenWebsite("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void Login(){

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./ExtentReports/Login.html");
        //ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Project Name", "Login Test");
        reports.setSystemInfo("Project Module", "Login");
        reports.setSystemInfo("Executed By", "Mustafizur Rahman");

        ExtentTest test = reports.createTest("Login Test");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        test.log(Status.INFO, "Id type done");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        test.log(Status.INFO, "Password type done");

        driver.findElement(By.cssSelector(".radius")).click();
        test.log(Status.INFO, "Login click done");

        test.log(Status.PASS, "Executed Successfully");
        //test.log(Status.SKIP, "Test Skipped");
        //test.log(Status.FAIL, "Test Failed");

        reports.flush();
    }

    @AfterClass
    public static void QuitBrowser(){
        FirefoxQuit();
    }
}
