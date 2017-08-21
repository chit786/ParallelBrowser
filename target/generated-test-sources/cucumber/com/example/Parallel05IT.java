package com.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = {"/Users/chitrang/IdeaProjects/ParallelBrowser/src/test/resources/features/UserForm.feature:16"},
        plugin = {"json:/Users/chitrang/IdeaProjects/ParallelBrowser/target/cucumber-parallel/5.json"},
        monochrome = true,
        glue = {"StepDefs"})
public class Parallel05IT extends AbstractTestNGCucumberTests {
}
