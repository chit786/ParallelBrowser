package runner;

import Base.BaseUtil;
import Base.BrowserFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Created by Chitrang Natu on 7/1/2016.
 */
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"StepDefs"},
        plugin = "json:target/chrome.json")
public class RunCukesByFeatureAndCompositionTest1  {
    private TestNGCucumberRunner testNGCucumberRunner;
    BaseUtil base ;
    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String browser) throws Exception {
        base.driver = BrowserFactory.getDriver(browser);
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        base.driver.quit();
        testNGCucumberRunner.finish();
    }
}