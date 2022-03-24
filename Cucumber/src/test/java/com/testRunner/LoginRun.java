package com.testRunner;

import io.cucumber.junit.*;
import org.junit.runner.*;

@CucumberOptions
        (
                features = "./Features/Login.feature",
                glue = "com.stepDefinition.LoginStepDefinition",
                monochrome = true,
                plugin = {"pretty","html:Reports/LoginReport.html"},
                tags = "@Normal"
                //tags = "@Normal or @DataDriven"
                //tags = "@Normal and @DataDriven"
        )
@RunWith(Cucumber.class)
public class LoginRun {
}
