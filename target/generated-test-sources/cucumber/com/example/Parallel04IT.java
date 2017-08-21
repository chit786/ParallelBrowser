package com.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = {"/Users/chitrang/IdeaProjects/ParallelBrowser/src/test/resources/features/UserForm.feature:5"},
        plugin = {"json:/Users/chitrang/IdeaProjects/ParallelBrowser/target/cucumber-parallel/4.json"},
        monochrome = true,
        glue = {"StepDefs"})
public class Parallel04IT extends AbstractTestNGCucumberTests {
}
