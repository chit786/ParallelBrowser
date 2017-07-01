package Base;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by chitrang on 28/05/17.
 */
public class BrowserFactory {

    public static WebDriver getDriver(String browser){

        WebDriver driver;
        switch(browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
                driver = new FirefoxDriver();

                //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
                driver = new ChromeDriver();
                String currentWindowHandle = driver.getWindowHandle();

                ((JavascriptExecutor)driver).executeScript("alert('Test')");
                driver.switchTo().alert().accept();

//Switch back to to the window using the handle saved earlier this will bring browser to the front of the screen
                driver.switchTo().window(currentWindowHandle);
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                break;
            default:
                System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                break;

        }

        driver.manage().window().maximize();
       // ((JavascriptExecutor)driver).executeScript("window.resizeTo(1024, 768);");


        return driver;
    }
}
