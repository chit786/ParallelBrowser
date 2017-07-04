package runner;

import Base.BaseUtil;
import Base.BrowserFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

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
    private Logger log;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(@Optional String browser, ITestContext ctx) throws Exception {
        base.setWebDriver(BrowserFactory.getDriver(browser));
        // logging the logger with test name + browser type + session id
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
        //base.driver.quit();
        testNGCucumberRunner.finish();
    }


}