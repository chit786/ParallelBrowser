package StepDefs;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.UserFormPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chitrang on 27/06/17.
 */
public class LoginStep extends BaseUtil {


    private BaseUtil base;
    private LoginPage loginPage;
    private UserFormPage userFormpage;

    public LoginStep(BaseUtil base){
        this.base = base;
       // this.loginPage = new LoginPage(base.getDriver(),base.getLogger());
        this.loginPage = new LoginPage(driver);

        this.userFormpage = new UserFormPage(driver);
        //this.userFormpage = new UserFormPage(base.getDriver(),base.getLogger());
    }




    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        //Create an ArrayList
        List<User> users =  new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);


        for (User user: users){
            //page.Login(user.username, user.password);
//            base.driver.findElement(By.name("UserName")).sendKeys(user.username);
//            base.driver.findElement(By.name("Password")).sendKeys(user.password);
            loginPage.Login(user.username,user.password);
        }
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        driver.navigate().to("http://executeautomation.com/demosite/Login.html");
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        loginPage.ClickLogin();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {

        Assert.assertTrue("UserForm not displayed",userFormpage.isUserFormVisible());
    }

    @Then("^I should see the userform page wrongly$")
    public void iShouldSeeTheUserformPageWrongly() throws Throwable {

    }

    @And("^I enter the ([^\"]*) and ([^\"]*)$")
    public void iEnterTheUsernameAndPassword(String userName, String passWord) throws Throwable {
        System.out.println("UName is :" + userName);
        System.out.println("PWord is :" + passWord);
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
