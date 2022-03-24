package com.testRunner;

import io.cucumber.junit.*;
import org.junit.runner.*;

@CucumberOptions
        (
                features = "./Features/Hooks.feature",
                glue = "com.stepDefinition.HooksStepDefinition",
                monochrome = true,
                plugin = {"pretty","html:Reports/HooksReport.json"}
        )
@RunWith(Cucumber.class)
public class HooksRun {
}
