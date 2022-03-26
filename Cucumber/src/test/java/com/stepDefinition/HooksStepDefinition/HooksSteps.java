package com.stepDefinition.HooksStepDefinition;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.cucumber.junit.*;
import org.apache.logging.log4j.*;

public class HooksSteps{
    public static Logger logger = LogManager.getLogger(Cucumber .class);

    @Before(order = 1)
    public void Setup1(){
        logger.trace("This is a Trace");
        logger.debug("This is a Debug");
        logger.info("This is an Info");
        logger.warn("This is a Warn");
        logger.error("This is an Error");
        logger.fatal("This is a Fatal");

        System.out.println("I am setup 1");
    }

    @Before(order = 2)
    public void Setup2(){
        System.out.println("I am setup 2");
    }

    @Before("@Sanity")
    public void Setup5(){
        System.out.println("I am setup 5");
    }
    @Before(value = "Sanity", order = 3)
    public void Setup6(){
        System.out.println("I am setup 6");
    }

    @BeforeStep()
    public void BeforeSetup(){
        System.out.println("I am Before Step");
    }
    //------------------------------------------------------//
    @Given("Launch browser")
    public void launch_browser() {
        System.out.println("Browser Launched");
    }

    @Then("Do anything")
    public void do_anything() {
        System.out.println("Doing.....");
    }

    @And("Close browser")
    public void close_browser() {
        System.out.println("Browser Closed");
    }
    //------------------------------------------------------//
    @AfterStep()
    public void AfterSetup(){
        System.out.println("I am Before Step");
    }

    @After(order = 1)
    public void Setup3(){
        System.out.println("I am setup 3");
    }

    @After(order = 2) //This will execute first
    public void Setup4(){
        System.out.println("I am setup 4");
    }
}
