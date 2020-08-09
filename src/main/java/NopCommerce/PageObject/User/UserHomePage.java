package NopCommerce.PageObject.User;

import NopCommerce.Interface.User.HomePageUI;
import NopCommerce.PageObject.User.MyAccount.UserMyAccountCustomerInfoTab;
import actions.common.functionHelper.AbstractPage;
import org.openqa.selenium.WebDriver;

public class UserHomePage extends AbstractPage {
    WebDriver driver;

    public UserHomePage(WebDriver webDriver) {
        driver = webDriver;
    }

    public UserRegisterPage clickRegisterButton() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
        return PageGenratorManager.getRegisterPage(driver);
    }

    public UserLoginPage clickLoginIcon() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver,HomePageUI.LOGIN_LINK);
        return PageGenratorManager.getUserLoginPage(driver);
    }

    public boolean checkLoginSuccess() {
        setDelayTime(1);
        waitForElementsVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public UserMyAccountCustomerInfoTab clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
        return PageGenratorManager.getMyAccountCustomerInfoTab(driver);
    }
}
