package actions.pageObject.liveGuru;

import actions.common.functionHelper.AbstractPage;
import interfaces.liveGuru.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends AbstractPage {
    private final WebDriver driver;
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_ACCOUNT_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_ACCOUNT_BUTTON);
    }

    public void inputDataToEmailTextbox(String value) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX,value);
    }

    public void inputDataToPasswordTextbox(String value) {
        waitForElementVisible(driver, RegisterPageUI.PASWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASWORD_TEXTBOX, value);
    }

    public void inputDataToConfirmPassTextbox(String value) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRMPASS_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRMPASS_TEXTBOX, value);
    }

    public void inputDataToLastNameTextbox(String value) {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, value);
    }

    public void inputDataToFirstNameTextbox(String value) {
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, value);
    }

    public String getRequireMessageAtFirstNameTextbox() {
        waitForElementVisible(driver,RegisterPageUI.REQUIRED_ERR_MESSAGE_FIRST_NAME_TEXTBOX);
        return getTextElement(driver,RegisterPageUI.REQUIRED_ERR_MESSAGE_FIRST_NAME_TEXTBOX);
    }

    public String getRequireMessageAtLastNameTextbox() {
        waitForElementVisible(driver,RegisterPageUI.REQUIRED_ERR_MESSAGE_LAST_NAME_TEXTBOX);
        return getTextElement(driver,RegisterPageUI.REQUIRED_ERR_MESSAGE_LAST_NAME_TEXTBOX);
    }

    public String getRequireMessageAtEmailTextbox() {
        waitForElementVisible(driver,RegisterPageUI.REQUIRED_ERR_MESSAGE_EMAIL_TEXTBOX);
        return getTextElement(driver,RegisterPageUI.REQUIRED_ERR_MESSAGE_EMAIL_TEXTBOX);
    }

    public String getRequireMessageAtPaswordTextbox(){
        waitForElementVisible(driver,RegisterPageUI.REQUIRED_ERR_MESSAGE_PASSWORD_TEXTBOX);
        return getTextElement(driver,RegisterPageUI.REQUIRED_ERR_MESSAGE_PASSWORD_TEXTBOX);
    }

    public String getRequireMessageAtConfirmPassTextbox() {
        waitForElementVisible(driver,RegisterPageUI.REQUIRED_ERR_MESSAGE_CONFIRM_PASS_TEXTBOX);
        return getTextElement(driver,RegisterPageUI.REQUIRED_ERR_MESSAGE_CONFIRM_PASS_TEXTBOX);
    }

    public String getInvalidErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver,RegisterPageUI.VALIDATE_ERR_MESSAGE_EMAIL_TEXTBOX);
        return getTextElement(driver,RegisterPageUI.VALIDATE_ERR_MESSAGE_EMAIL_TEXTBOX);
    }

    public String getInvalidErrorPasswordTextbox() {
        waitForElementVisible(driver,RegisterPageUI.VALIDATE_ERR_MESSAGE_PASSWORD_TEXTBOX);
        return getTextElement(driver,RegisterPageUI.VALIDATE_ERR_MESSAGE_PASSWORD_TEXTBOX);
    }

    public String getInvalidErrorConfirmPassTextbox() {
        waitForElementVisible(driver,RegisterPageUI.VALIDATE_ERR_MESSAGE_CONFIRM_PASSWORD_TEXTBOX);
        return getTextElement(driver,RegisterPageUI.VALIDATE_ERR_MESSAGE_CONFIRM_PASSWORD_TEXTBOX);
    }
}
