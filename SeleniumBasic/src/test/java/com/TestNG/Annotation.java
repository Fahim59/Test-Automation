package com.TestNG;

import org.testng.annotations.*;

public class Annotation {

    @BeforeClass //Executes only once before all test methods
    public static void BrowserLaunch(){
        System.out.println("Browser Successfully Launched");
        System.out.println("-------------------------------");
    }
    @BeforeMethod //Executes before every test methods
    public static void OpenWebsite(){
        System.out.println("Website Successfully Launched");
    }

    @Test(description = "This is for valid scenario", priority = 2)
    public static void Test1(){
        System.out.println("Executed Test 1");
    }

    @Test(description = "This is for invalid scenario", priority = 1)
    public static void Test2(){
        System.out.println("Executed Test 2");
    }

    @Test(description = "This is for skip scenario", priority = 3, enabled = false)
    public static void Test3(){
        System.out.println("Executed Test 3");
    }

    @AfterMethod //Executes after every test methods
    public static void Screenshoot(){
        System.out.println("Screenshoot Successfully Taken");
        System.out.println("-------------------------------");
    }
    @AfterClass //Executes only once after all test methods
    public static void BrowserQuit(){
        System.out.println("Browser Successfully Closed");
    }
}
