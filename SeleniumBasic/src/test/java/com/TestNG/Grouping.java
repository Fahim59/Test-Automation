package com.TestNG;
import org.testng.annotations.*;

public class Grouping{

    @BeforeClass
    public static void LaunchBrowser(){ System.out.println("Launch Browser");}

    @Test(groups = {"Unit"})
    public static void Test1(){
        System.out.println("Executed Test 1");
    }

    @Test(groups = {"Regression"})
    public static void Test2(){
        System.out.println("Executed Test 2");
    }

    @Test(groups = {"Unit", "Regression"})
    public static void Test3(){
        System.out.println("Executed Test 3");
    }

    @AfterClass
    public static void QuitBrowser(){
        System.out.println("Quit Browser");
    }
}
