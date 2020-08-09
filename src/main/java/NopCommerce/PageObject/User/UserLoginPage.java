package NopCommerce.PageObject.User;

import NopCommerce.Interface.User.LoginPageUI;
import actions.common.functionHelper.AbstractPage;
import org.openqa.selenium.WebDriver;

public class UserLoginPage extends AbstractPage {
    WebDriver driver;
    public UserLoginPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterDataToEmailTextBox(String email) {
        waitForElementsVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX,email);
    }

    public void enterDataToPasswordTextBox(String password) {
        waitForElementsVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public UserHomePage clickLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGenratorManager.getHomepage(driver);
    }

    public String getErrValidateEmailTextBox() {
        waitForElementsVisible(driver,LoginPageUI.ERR_VALIDATE_EMAIL);
        return getTextElement(driver,LoginPageUI.ERR_VALIDATE_EMAIL);
    }

    public String getValidateErrLogin() {
        waitForElementsVisible(driver,LoginPageUI.LOGIN_ERROR_MESSAGE);
        return getTextElement(driver,LoginPageUI.LOGIN_ERROR_MESSAGE);
    }

}
