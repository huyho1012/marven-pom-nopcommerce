package NopCommerce.PageObject.User.MyAccount;

import NopCommerce.Interface.User.MyAccount.MyAccounChangePassUI;
import NopCommerce.PageObject.User.PageGenratorManager;
import NopCommerce.PageObject.User.UserHomePage;
import actions.common.functionHelper.AbstractTest;
import org.openqa.selenium.WebDriver;

public class UserMyAccountChangePassword extends AbstractTest {
    WebDriver driver;
    public UserMyAccountChangePassword(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterOldPassWord(String oldPass) {
        waitForElementVisible(driver, MyAccounChangePassUI.OLD_PASS_TEXT_BOX);
        sendKeyToElement(driver, MyAccounChangePassUI.OLD_PASS_TEXT_BOX,oldPass);
    }

    public void enterNewPassWord(String newPassword) {
        waitForElementVisible(driver, MyAccounChangePassUI.NEW_PASS_TEXT_BOX);
        sendKeyToElement(driver, MyAccounChangePassUI.NEW_PASS_TEXT_BOX,newPassword);
        
    }

    public void enterConfirmPassWord(String newPassword) {
        waitForElementVisible(driver, MyAccounChangePassUI.CONFIRM_PASS_TEXT_BOX);
        sendKeyToElement(driver, MyAccounChangePassUI.CONFIRM_PASS_TEXT_BOX,newPassword);
    }

    public void clickConfirmChangePass() {
        setDelayTime(1);
        waitForElementVisible(driver, MyAccounChangePassUI.CHANGE_PASS_BUTTON);
        clickToElement(driver, MyAccounChangePassUI.CHANGE_PASS_BUTTON);
    }

    public String checkChangePasswordSuccess() {
        setDelayTime(1);
        waitForElementVisible(driver, MyAccounChangePassUI.MESSAGE_CHANGE_PASS);
        return getTextElement(driver, MyAccounChangePassUI.MESSAGE_CHANGE_PASS);
    }

    public UserHomePage clickButtonLogout() {
        setDelayTime(1);
        waitForElementVisible(driver, MyAccounChangePassUI.LOGOUT_LINK);
        clickToElement(driver, MyAccounChangePassUI.LOGOUT_LINK);
        return PageGenratorManager.getHomepage(driver);
    }
}
