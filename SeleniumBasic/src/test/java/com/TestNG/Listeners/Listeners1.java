package com.TestNG.Listeners;

import org.testng.*;
import org.testng.annotations.*;

public class Listeners1{

    @Test
    public void Test1(){
        Assert.assertEquals("5","5");
    }

    @Test
    public void Test2(){
        Assert.fail();
    }
}
