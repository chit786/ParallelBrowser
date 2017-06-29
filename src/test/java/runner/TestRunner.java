package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


/**
 * Created by chitrang on 28/06/17.
 */

//@RunWith(Cucumber.class) --junit
@CucumberOptions(features={"src/test/java/features"}, format={"json:target/cucumber.json","html:target/site/cucumber-pretty"} , glue = {"StepDefs"})
public class TestRunner extends AbstractTestNGCucumberTests{
}
