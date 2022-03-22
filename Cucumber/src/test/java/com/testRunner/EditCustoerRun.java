package com.testRunner;

import io.cucumber.junit.*;
import org.junit.runner.*;

@CucumberOptions
        (
                features = "./Features/EditCustomer.feature",
                glue = "com.stepDefinition.EditCustomerStepDefinition",
                dryRun = true,
                monochrome = true,
                plugin = {"pretty","html:Reports/EditCustomerReport.html"}
        )
@RunWith(Cucumber.class)
public class EditCustoerRun {
}
