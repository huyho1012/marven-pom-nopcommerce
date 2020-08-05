package actions.pageObject.bankGuru;


import actions.common.bankGuru.AbstractPageBankGuru;
import interfaces.bankGuru.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends AbstractPageBankGuru {
    WebDriver driver;
    public RegisterPageObject(WebDriver webDriver){
        driver = webDriver;
    }
    public void enterToEmailIDTextbox(String userID) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_FIELD);
        sendKeyToElement(driver,RegisterPageUI.EMAIL_ID_FIELD, userID);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver,RegisterPageUI.BUTTON_SUBMIT);
        clickToElement(driver, RegisterPageUI.BUTTON_SUBMIT);
    }

    public String getValueOnEmailID() {
        waitForElementVisible(driver,RegisterPageUI.USER_ID_COLUMN_DATA);
        return getTextElement(driver,RegisterPageUI.USER_ID_COLUMN_DATA);
    }

    public String getValueOnPass() {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_COLUMN_DATA);
        return getTextElement(driver,RegisterPageUI.PASSWORD_COLUMN_DATA);
    }

    public LoginPageObject openLoginPage(String loginPageURL){
        openPage(driver,loginPageURL);
        return Pagenerator.getLoginPage(driver);
    }
}
