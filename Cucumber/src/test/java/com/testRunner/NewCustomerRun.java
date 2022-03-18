package com.testRunner;

import io.cucumber.junit.*;
import org.junit.runner.*;

@CucumberOptions
        (
                features = "./Features/NewCustomer.feature",
                glue = "com.stepDefinition",
                monochrome = true,
                plugin = {"pretty","html:Reports/NewCustomerReport.html"}
        )

@RunWith(Cucumber.class)
public class NewCustomerRun {
}
