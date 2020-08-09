package testcases.Nopcommerce.User;

import NopCommerce.PageObject.User.UserHomePage;
import NopCommerce.PageObject.User.PageGenratorManager;
import NopCommerce.PageObject.User.UserLoginPage;
import NopCommerce.Variable;
import actions.browserFactory.BrowserDriver;
import actions.browserFactory.DriverManager;
import actions.common.functionHelper.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    UserHomePage userHomePage;
    UserLoginPage userLoginPage;
    String email;

    @Parameters("browser")
    @BeforeTest
    public void preconditionTest(String browserName) {
        email = "huyho1210" + randomNumber() + "@mailinator.com";
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(Variable.URL_USER_PAGE);
        userHomePage = PageGenratorManager.getHomepage(driver);
        userLoginPage = userHomePage.clickLoginIcon();
    }

    @Test
    public void TC01_Login_With_Empty_User(){
        userLoginPage.setDelayTime(1);
        userLoginPage.enterDataToEmailTextBox("");
        userLoginPage.enterDataToPasswordTextBox("");
        userLoginPage.clickLoginButton();
        verifyEquals(userLoginPage.getErrValidateEmailTextBox(),"Please enter your email");
    }

    @Test
    public void TC02_Login_With_Invalid_Email(){
        userLoginPage.setDelayTime(1);
        userLoginPage.enterDataToEmailTextBox("huy@");
        userLoginPage.enterDataToPasswordTextBox("123456");
        userLoginPage.clickLoginButton();
        verifyEquals(userLoginPage.getErrValidateEmailTextBox(),"Wrong email");
    }

    @Test
    public void TC03_Login_With_Email_Has_Not_Create(){
        userLoginPage.setDelayTime(1);
        userLoginPage.enterDataToEmailTextBox("emcoyeuanhkhong1235@yahoo.com");
        userLoginPage.enterDataToPasswordTextBox("123456");
        userLoginPage.clickLoginButton();
        verifyEquals(userLoginPage.getValidateErrLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
    }
    @Test
    public void TC04_Login_With_Password_Is_Blank(){
        userLoginPage.setDelayTime(1);
        userLoginPage.enterDataToEmailTextBox(Variable.USER_ACCOUNT);
        userLoginPage.enterDataToPasswordTextBox("");
        userLoginPage.clickLoginButton();
        verifyEquals(userLoginPage.getValidateErrLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
    }
    @Test
    public void TC05_Login_With_Password_Incorrect(){
        userLoginPage.setDelayTime(1);
        userLoginPage.enterDataToEmailTextBox(Variable.USER_ACCOUNT);
        userLoginPage.enterDataToPasswordTextBox("01231321321");
        userLoginPage.clickLoginButton();
        verifyEquals(userLoginPage.getValidateErrLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
    }
    @Test
    public void TC05_Login_With_Valid_Info(){
        userLoginPage.setDelayTime(1);
        userLoginPage.enterDataToEmailTextBox("huyho1210@gmail.com");
        userLoginPage.enterDataToPasswordTextBox("123456");
        userHomePage = userLoginPage.clickLoginButton();
        verifyTrue(userHomePage.checkLoginSuccess());
    }
}
