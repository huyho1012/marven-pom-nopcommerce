package NopCommerce.PageObject.User;

import NopCommerce.Interface.User.RegisterPageUI;
import actions.common.functionHelper.AbstractPage;
import org.openqa.selenium.WebDriver;

public class UserRegisterPage extends AbstractPage {
    WebDriver driver;
    public UserRegisterPage(WebDriver webDriver){
        driver = webDriver;
    }

    public String getValidateErrorMessage(WebDriver driver, String fieldValue) {
        waitForElementsVisible(driver, RegisterPageUI.VALIDATE_ERROR_FIELD,fieldValue);
        return getTextElement(driver, RegisterPageUI.VALIDATE_ERROR_FIELD,fieldValue);
    }

    public boolean checkRegisterPageDisplay() {
        waitForElementsVisible(driver,RegisterPageUI.TITLE_PAGE);
        return isElementDisplay(driver,RegisterPageUI.TITLE_PAGE);
    }

    public void clickRegisterButton() {
        scrollIntoViewByJS(driver,RegisterPageUI.REGISTER_BUTTON);
        setDelayTime(1);
        clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
    }

    public void chooseGender(String value) {
        waitForElementsVisible(driver,RegisterPageUI.GENDER_OPTION,value);
        clickToElement(driver,RegisterPageUI.GENDER_OPTION,value);
    }

    public void enterDataToDynamicField(WebDriver driver,String fieldName, String value) {
        waitForElementsVisible(driver,RegisterPageUI.FIELD_NAME,fieldName);
        sendKeyToElement(driver,RegisterPageUI.FIELD_NAME,value,fieldName);
    }

    public void chooseBirthday(WebDriver driver, String dayItem, String monthItem, String yearItem, String dayDropdown, String monthDropdown,String yearDropdown) {
        selectItemOnDropdown(driver,RegisterPageUI.SELECTED_DAY_DROPDOWN,dayItem,dayDropdown);
        selectItemOnDropdown(driver,RegisterPageUI.SELECTED_DAY_DROPDOWN,monthItem,monthDropdown);
        selectItemOnDropdown(driver,RegisterPageUI.SELECTED_DAY_DROPDOWN,yearItem,yearDropdown);
    }

    public String getSummaryValidationErr(WebDriver driver) {
        return getTextElement(driver, RegisterPageUI.SUMMARY_VALIDATION_ERROR);
    }

    public boolean getRegisterSuccessMessage(WebDriver driver) {
        waitForElementsVisible(driver,RegisterPageUI.MESSAGE_VERIFY_SUCCESS);
        return isElementUnDisplay(driver,RegisterPageUI.MESSAGE_VERIFY_SUCCESS);
    }
    public UserHomePage RegisterUserAccount(WebDriver driver, String genderValue, String firstName,
                        String lastName, String dayItem, String monthItem,
                        String yearItem, String email, String companyName,
                        String pass, String confirmPass) {
        setDelayTime(1);
        waitForElementClickable(driver, RegisterPageUI.GENDER_OPTION, genderValue);
        clickToElement(driver, RegisterPageUI.GENDER_OPTION, genderValue);
        waitForElementsVisible(driver, RegisterPageUI.FIELD_NAME, "FirstName");
        sendKeyToElement(driver, RegisterPageUI.FIELD_NAME, firstName, "FirstName");
        waitForElementsVisible(driver, RegisterPageUI.FIELD_NAME, "LastName");
        sendKeyToElement(driver, RegisterPageUI.FIELD_NAME, lastName, "LastName");
        selectItemOnDropdown(driver, RegisterPageUI.SELECTED_DAY_DROPDOWN, dayItem, "DateOfBirthDay");
        selectItemOnDropdown(driver, RegisterPageUI.SELECTED_DAY_DROPDOWN, monthItem, "DateOfBirthMonth");
        selectItemOnDropdown(driver, RegisterPageUI.SELECTED_DAY_DROPDOWN, yearItem, "DateOfBirthYear");
        waitForElementsVisible(driver, RegisterPageUI.FIELD_NAME, "Email");
        sendKeyToElement(driver, RegisterPageUI.FIELD_NAME, email, "Email");
        waitForElementsVisible(driver, RegisterPageUI.FIELD_NAME, "Company");
        sendKeyToElement(driver, RegisterPageUI.FIELD_NAME, companyName, "Company");
        waitForElementsVisible(driver, RegisterPageUI.FIELD_NAME, "Password");
        sendKeyToElement(driver, RegisterPageUI.FIELD_NAME, pass, "Password");
        waitForElementsVisible(driver, RegisterPageUI.FIELD_NAME, "ConfirmPassword");
        sendKeyToElement(driver, RegisterPageUI.FIELD_NAME, confirmPass, "ConfirmPassword");
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
        setDelayTime(1);
        waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
        return PageGenratorManager.getHomepage(driver);
    }
}
