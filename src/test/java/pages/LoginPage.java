package pages;

import Base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by chitrang on 28/06/17.
 */
public class LoginPage extends BasePageObject<LoginPage> {



    public LoginPage(WebDriver driver) {
        super(driver);
        getUniqueElement(btnLogin);
    }


    private By txtUserName = By.name("UserName");
    private By txtPassword = By.name("Password");
    private By btnLogin = By.name("Login");


    public void Login(String userName, String password)
    {

        type(userName,txtUserName);
        type(userName,txtPassword);

    }

    public UserFormPage ClickLogin()
    {

        submit(btnLogin);

        return new UserFormPage(driver);

    }
}
