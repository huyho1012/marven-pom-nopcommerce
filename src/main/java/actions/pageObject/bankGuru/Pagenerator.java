package actions.pageObject.bankGuru;

import org.openqa.selenium.WebDriver;

public class Pagenerator {
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static CustomerPageObject getCustomerPage(WebDriver driver){
        return new CustomerPageObject(driver);
    }
    public static CustomerPageObject getEditCustomerPage(WebDriver driver){
        return new CustomerPageObject(driver);
    }
}
