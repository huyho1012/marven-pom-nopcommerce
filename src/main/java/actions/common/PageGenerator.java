package actions.common;

import org.openqa.selenium.WebDriver;
import pageObject.liveGuru.LoginPageObject;
import pageObject.liveGuru.MyDashboardPageObject;
import pageObject.liveGuru.RegisterPageObject;

public class PageGenerator {

    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static MyDashboardPageObject getMyHomePage(WebDriver driver){
        return new MyDashboardPageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }


}
