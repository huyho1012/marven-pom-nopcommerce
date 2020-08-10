package NopCommerce.PageObject.User;

import NopCommerce.PageObject.User.MyAccount.UserMyAccountAddressTab;
import NopCommerce.PageObject.User.MyAccount.UserMyAccountChangePassword;
import NopCommerce.PageObject.User.MyAccount.UserMyAccountCustomerInfoTab;
import actions.common.functionHelper.AbstractPage;
import org.openqa.selenium.WebDriver;

public class PageGenratorManager extends AbstractPage {

    public static UserHomePage getHomepage(WebDriver driver){
        return new UserHomePage(driver);
    }
    public static UserRegisterPage getRegisterPage(WebDriver driver){
        return new UserRegisterPage(driver);
    }
    public static UserLoginPage getUserLoginPage(WebDriver driver){
        return new UserLoginPage(driver);
    }
    public static UserMyAccountCustomerInfoTab getMyAccountCustomerInfoTab(WebDriver driver){
        return new UserMyAccountCustomerInfoTab(driver);
    }
    public static UserMyAccountAddressTab getMyAccountAddressTab(WebDriver driver){
        return new UserMyAccountAddressTab(driver);
    }
    public static UserMyAccountChangePassword getMyAccountChangePass(WebDriver driver){
        return new UserMyAccountChangePassword(driver);
    }
}
