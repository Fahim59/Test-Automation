package com.TestNG;

import org.testng.annotations.*;

public class LoginTest {

    @BeforeClass //Executes only once before all test methods
    public static void BrowserLaunch(){
        System.out.println("Browser Successfully Launched");
        System.out.println("-------------------------------");
    }

    @Test(description = "This is for valid scenario", priority = 1)
    public static void Test1(){
        System.out.println("Executed Test 1");
    }

    @AfterClass //Executes only once after all test methods
    public static void BrowserQuit(){

        System.out.println("Browser Successfully Closed");
        System.out.println("-------------------------------");
    }
}
