package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Created by chitrang on 28/06/17.
 */
public class BaseUtil {

//    public static WebDriver driver;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static ThreadLocal<Logger> log = new ThreadLocal<Logger>() ;

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setWebDriver(WebDriver drivernew) {
        driver.set(drivernew);
    }

    public static void setLogger(Logger lognew){
        log.set(lognew);

    }

    public static Logger getLogger() {
        return log.get();
    }

    public static void editLogger(Logger lognew){
        log.remove();
        log.set(lognew);
    }


}
