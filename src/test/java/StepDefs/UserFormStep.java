package StepDefs;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.LoginPage;
import pages.UserFormPage;

import java.util.List;

/**
 * Created by chitrang on 29/06/17.
 */
public class UserFormStep extends BaseUtil {


    private BaseUtil base;
    private LoginPage loginPage;
    private UserFormPage userFormpage;

    public UserFormStep(BaseUtil base){
        this.base = base;
        this.loginPage = new LoginPage(base.getDriver(),base.getLogger());
        //this.userFormpage = new UserFormPage(base.driver);
    }


    @Given("^I am logged in to the application$")
    public void iAmLoggedInToTheApplication(DataTable table) throws Throwable {
        base.getDriver().navigate().to("http://executeautomation.com/demosite/Login.html");
        //Create an ArrayList
        List<List<String>> data = table.raw();
        //Store all the users
        loginPage.Login(data.get(1).get(0),data.get(1).get(1));

        this.userFormpage = loginPage.ClickLogin();
    }

    @And("^I fill following user details in the form$")
    public void iFillFollowingUserDetailsInTheForm(DataTable table) throws Throwable {

        List<List<String>> data = table.raw();

        this.userFormpage.fillUserForm(data);


    }

    @And("^I click save button$")
    public void iClickSaveButton() throws Throwable {
        this.userFormpage.saveUserForm();
    }


    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username= userName;
            password = passWord;
        }
    }

}
