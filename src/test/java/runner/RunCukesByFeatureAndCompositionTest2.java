package runner;

import Base.BaseUtil;
import Base.BrowserFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;

/**
 * Created by Chitrang Natu on 7/1/2016.
 */
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"StepDefs"},
        plugin = "json:target/firefox.json")
public class RunCukesByFeatureAndCompositionTest2 {
    private TestNGCucumberRunner testNGCucumberRunner;
    BaseUtil base ;
    private Logger log;
    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(@Optional String browser, ITestContext ctx) throws Exception {
        base.setWebDriver(BrowserFactory.getDriver(browser));
        log = Logger.getLogger(ctx.getCurrentXmlTest().getName() + " - " + ctx.getCurrentXmlTest().getParameter("browser"));
        //base.driver = BrowserFactory.getDriver(browser);

        base.setLogger(log);
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
        WebDriver driver = base.getDriver();
        if(driver!=null){

            driver.quit();
        }
       // base.driver.quit();
        log.info(base.getLogger().getName() + " - Finished");
        testNGCucumberRunner.finish();
    }
}
