package com.TestNG.FailedTestCases;

import org.testng.*;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int limit = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if(counter < limit){
            counter++;
            return true;
        }
        return false;
    }
}
