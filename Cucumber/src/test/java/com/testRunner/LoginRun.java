package com.testRunner;

import io.cucumber.junit.*;
import org.junit.runner.*;

@CucumberOptions
        (
                features = "./Features/Login.feature",
                glue = "com.stepDefinition.LoginStepDefinition",
                monochrome = true,
                plugin = {"pretty","html:Reports/LoginReport.html"},
                /*plugin = {"pretty","html:target/cucumber_reports/cucumber.html",
                "json:target/cucumber_reports/cucumber.json", "junit:target/cucumber_reports/cucumber.xml",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},*/
                tags = "@Normal" //tags = "@Normal or @DataDriven" //tags = "@Normal and @DataDriven"
        )
@RunWith(Cucumber.class)
public class LoginRun {
}
