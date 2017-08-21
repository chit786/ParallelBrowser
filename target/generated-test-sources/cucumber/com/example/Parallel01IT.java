package com.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = {"/Users/chitrang/IdeaProjects/ParallelBrowser/src/test/resources/features/Login.feature:4"},
        plugin = {"json:/Users/chitrang/IdeaProjects/ParallelBrowser/target/cucumber-parallel/1.json"},
        monochrome = true,
        glue = {"StepDefs"})
public class Parallel01IT extends AbstractTestNGCucumberTests {

}
