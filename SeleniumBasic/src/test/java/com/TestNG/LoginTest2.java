package com.TestNG;

import org.testng.annotations.*;

public class LoginTest2 {

    @BeforeClass //Executes only once before all test methods
    public static void BrowserLaunch(){
        System.out.println("Browser Successfully Launched");
        System.out.println("-------------------------------");
    }

    @Test(description = "This is for invalid scenario", priority = 1)
    public static void Test2(){
        System.out.println("Executed Test 2");
    }

    @AfterClass //Executes only once after all test methods
    public static void BrowserQuit(){

        System.out.println("Browser Successfully Closed");
        System.out.println("-------------------------------");
    }
}
