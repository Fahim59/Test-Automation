package com.TestNG.Screenshot;

import com.Base.*;
import org.testng.*;

import java.io.*;

public class SS_Listeners extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");

        try{
            Screenshot(result.getMethod().getMethodName()); //Taken from BaseClass
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped");

        try{
            Screenshot(result.getMethod().getMethodName()); //Taken from BaseClass
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
