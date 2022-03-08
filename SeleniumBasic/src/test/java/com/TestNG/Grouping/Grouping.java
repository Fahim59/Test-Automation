package com.TestNG.Grouping;
import org.testng.annotations.*;

public class Grouping{

    @Test(groups = {"Unit"})
    public static void Test1(){
        System.out.println("Unit Test Executed");
    }

    @Test(groups = {"Regression"})
    public static void Test2(){
        System.out.println("Regression Test Executed");
    }

    @Test(groups = {"Unit", "Regression"})
    public static void Test3(){
        System.out.println("Mix Test Executed");
    }
}
