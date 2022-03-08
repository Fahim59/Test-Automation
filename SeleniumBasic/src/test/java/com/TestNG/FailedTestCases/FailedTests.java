package com.TestNG.FailedTestCases;

import org.testng.*;
import org.testng.annotations.*;

public class FailedTests{

    @Test
    public static void Test1(){
        Assert.assertEquals(5,3);
    }

    @Test
    public static void Test2(){
        Assert.fail();
    }

    @Test
    public static void Test3(){
        Assert.assertEquals(5,5);
    }
}
