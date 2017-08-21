package com.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = {"/Users/chitrang/IdeaProjects/ParallelBrowser/src/test/resources/features/Login.feature:13"},
        plugin = {"json:/Users/chitrang/IdeaProjects/ParallelBrowser/target/cucumber-parallel/2.json"},
        monochrome = true,
        glue = {"StepDefs"})
public class Parallel02IT extends AbstractTestNGCucumberTests {
}
