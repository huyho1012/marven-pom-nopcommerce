package actions.common.functionHelper;

import actions.pageObject.liveGuru.MyDashboardPageObject;
import actions.pageObject.liveGuru.RegisterPageObject;
import actions.pageObject.wordpress.Admin.LoginPageObject;
import org.openqa.selenium.WebDriver;


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
