package com.TestNG;

import org.testng.*;

public class Listeners implements ITestListener {

    @Override
    public void onStart(ITestContext context){
        System.out.println("On Start ");
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Started " +result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Success " +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Failed " +result.getName() + " " +result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Skipped " +result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        System.out.println("---" +result.getName());
    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println("Finished ");
    }
}
