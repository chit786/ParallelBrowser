package StepDefs;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by chitrang on 27/06/17.
 */
public class Hook extends BaseUtil{

    private BaseUtil base;

    public Hook(BaseUtil base){
        this.base = base;
    }

    @Before
    public void InitializeTest(){
        System.out.println("in before");
       // System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        base.driver = new FirefoxDriver();
        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void TearDownTest(){
        System.out.println("in after");
        base.driver.quit();



    }



}
