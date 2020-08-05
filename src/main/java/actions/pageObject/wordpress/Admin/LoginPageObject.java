package actions.pageObject.wordpress.Admin;

import actions.pageObject.wordpress.common.CommonPageObject;
import actions.pageObject.wordpress.common.PageGeneratorManager;
import interfaces.wordPress.Admin.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends CommonPageObject {
    WebDriver driver;
    public LoginPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }
    public void inputUserName(String userName) {
        waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX,userName);
    }
    public void clickToContinueButton() {
        waitForElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
        clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
    }

    public String getErrMessageUsernameTextBox() {
        waitForElementVisible(driver,LoginPageUI.VALIDATE_ERR_MESSAGE_USERNAME);
        return getTextElement(driver,LoginPageUI.VALIDATE_ERR_MESSAGE_USERNAME);
    }

    public String getErrMessagePasswordTextBox() {
        waitForElementVisible(driver,LoginPageUI.VALIDATE_ERR_MESSAGE_PASSWORD);
        return getTextElement(driver,LoginPageUI.VALIDATE_ERR_MESSAGE_PASSWORD);
    }

    public void inputPassword(String passWord) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX, passWord);
    }
    public DashboardPageObject clickToDashboard(WebDriver driver){
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getDashboardAdminPage(driver);
    }
    public DashboardPageObject clickToDashboardAgain(WebDriver driver){
        setDelayTime(1);
        waitForElementClickable(driver, LoginPageUI.CONTINUE_AGAIN_BUTTON);
        clickToElement(driver,LoginPageUI.CONTINUE_AGAIN_BUTTON);
        return PageGeneratorManager.getDashboardAdminPage(driver);
    }

}
