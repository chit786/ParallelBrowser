package pages;

import Base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by chitrang on 29/06/17.
 */
public class UserFormPage extends BasePageObject<UserFormPage> {


    public UserFormPage(WebDriver driver) {
        super(driver);
        getUniqueElement(txtFirstName);
    }

    private By txtFirstName = By.id("FirstName");
    private By selTitle = By.id("TitleId");
    private By txtInital = By.id("Initial");
    private By radMale = By.name("Male");
    private By radFemale = By.name("Female");
    private By chkEngligh = By.name("english");
    private By chkHindi = By.name("Hindi");
    private By btnSave = By.name("Save");

    public void fillUserForm(List<List<String>> data){
        new Select(find(selTitle)).selectByVisibleText(data.get(1).get(0));
        type(data.get(1).get(1),txtInital);
        if(data.get(1).get(4).equals("Male")){
            click(radMale);
        }else{
            click(radFemale);
        }
        type(data.get(1).get(2),txtFirstName);
        if(data.get(1).get(5).equals("hindi")){
            click(chkHindi);
        }else{
            click(chkEngligh);
        }

    }

    public void saveUserForm(){
        click(btnSave);
    }

    public Boolean isUserFormVisible(){
        waitForVisibilityOf(txtInital,10);
        return find(txtInital).isDisplayed();
    }

}
