package com.bdd.with.mocking;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true)
public class IntegrationTest {

}
