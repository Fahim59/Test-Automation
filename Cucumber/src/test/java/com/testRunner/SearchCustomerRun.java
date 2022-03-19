package com.testRunner;


import io.cucumber.junit.*;
import org.junit.runner.*;

@CucumberOptions
        (
                features = "./Features/SearchCustomer.feature",
                glue = "com.stepDefinition",
                //dryRun = true,
                monochrome = true,
                plugin = {"pretty","html:Reports/SearchCustomerReport.html"}
        )
@RunWith(Cucumber.class)
public class SearchCustomerRun {
}