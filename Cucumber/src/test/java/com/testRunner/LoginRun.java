package com.testRunner;

import io.cucumber.junit.*;
import org.junit.runner.*;

@CucumberOptions
        (
                features = "./Features/Login.feature",
                glue = "com.stepDefinition",
                monochrome = true,
                plugin = {"pretty","html:Reports/LoginReport.html"}
        )
@RunWith(Cucumber.class)
public class LoginRun {
}
