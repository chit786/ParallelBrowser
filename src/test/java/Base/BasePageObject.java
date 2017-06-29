package Base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by chitrang on 29/06/17.
 */
public class BasePageObject<T> {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private By UniqueElement;
    private Integer genericTimeout = 10;


    protected BasePageObject(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(driver,genericTimeout);
    }

    protected void getUniqueElement(By uniqueElement){
        this.UniqueElement = uniqueElement;
    };

    protected void isLoaded() throws Error {
        //Define a list of WebElements that match the unique element locator for the page
        if(this.UniqueElement!=null){
            List<WebElement> uniqueElement = driver.findElements(this.UniqueElement);

            // Assert that the unique element is present in the DOM
            Assert.assertTrue("Unique Element \'" + this.UniqueElement.toString() + "\' not found for " + this.getClass().getSimpleName(), (uniqueElement.size() > 0));

            // Wait until the unique element is visible in the browser and ready to use. This helps make sure the page is
            // loaded before the next step of the tests continue.
            waitForVisibilityOf((this.UniqueElement),genericTimeout);
        }


    }





    @SuppressWarnings("unchecked")
    protected T getPage(String url){
        driver.get(url);
        return (T) this;
    }

    protected void type(String text,By element){

        find(element).sendKeys(text);

    }

    protected void click(By element){

        find(element).click();

    }


    protected void submit(By element){

        find(element).submit();

    }


    protected WebElement find(By element) throws NoSuchElementException {
        //waitForVisibilityOff(element,3);
        return driver.findElement(element);
    }


    protected void waitForVisibilityOf(By locator,Integer... timeOutInSeconds){
        int attempts = 0;
        while(attempts<2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
            }catch (StaleElementReferenceException e){

            }
            attempts++;
        }
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){

        timeOutInSeconds = timeOutInSeconds !=null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.until(condition);

    }

}
