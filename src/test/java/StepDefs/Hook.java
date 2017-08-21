package StepDefs;

import Base.BaseUtil;
import Base.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by chitrang on 27/06/17.
 */
public class Hook extends BaseUtil {

    private BaseUtil base;
    private Logger log;
    private String scName,oldName;
    private String[] oldNameParams;


    public Hook(BaseUtil base){
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) throws MalformedURLException{
        System.out.println("in before");
        scName = scenario.getName();

//        oldName = base.getLogger().getName();
//        oldNameParams = oldName.split("-");
//        if(oldNameParams.length>2){
//            oldName = oldNameParams[0].toString() + " - " + oldNameParams[1].toString();
//        }
//
//        log = Logger.getLogger(oldName + " - " + scName);
//
//        base.editLogger(log);

        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        //base.driver = new FirefoxDriver();

        base.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void TearDownTest(Scenario scenario){
        System.out.println("in after");
        //WebDriver driver = base.getDriver();

        if(scenario.isFailed())
        {
            try {
                WebDriver augmentedDriver = new Augmenter().augment(driver);
                File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
                byte[] data = FileUtils.readFileToByteArray(scrFile);
                scenario.embed(data, "image/png");
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        driver.quit();

    }




}
