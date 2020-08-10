package NopCommerce.PageObject.User.MyAccount;


import NopCommerce.Interface.User.MyAccount.UserMyAccountCustomerInfoTabUI;
import actions.common.functionHelper.AbstractPage;
import org.openqa.selenium.WebDriver;

public class UserMyAccountCustomerInfoTab extends AbstractPage {
    WebDriver driver;
    public UserMyAccountCustomerInfoTab(WebDriver webDriver){
        driver = webDriver;
    }


    public void chooseCustomerGender(String value) {
        waitForElementsVisible(driver, UserMyAccountCustomerInfoTabUI.GENDER_OPTION,value);
        clickToElement(driver, UserMyAccountCustomerInfoTabUI.GENDER_OPTION,value);
    }

    public void enterDynamicDataOnCustomerInfo(String fieldName, String value) {
        waitForElementsVisible(driver, UserMyAccountCustomerInfoTabUI.FIELD_NAME,fieldName);
        sendKeyToElement(driver, UserMyAccountCustomerInfoTabUI.FIELD_NAME,value,fieldName);
    }

    public void chooseCustomerBirthday(String dayItem, String monthItem, String yearItem) {
        selectItemOnDropdown(driver, UserMyAccountCustomerInfoTabUI.SELECTED_DAY_DROPDOWN,dayItem,"DateOfBirthDay");
        selectItemOnDropdown(driver, UserMyAccountCustomerInfoTabUI.SELECTED_DAY_DROPDOWN,monthItem,"DateOfBirthMonth");
        selectItemOnDropdown(driver, UserMyAccountCustomerInfoTabUI.SELECTED_DAY_DROPDOWN,yearItem,"DateOfBirthYear");
    }

    public String getDynamicDataOnCustomer(String fieldName) {
        waitForElementsVisible(driver, UserMyAccountCustomerInfoTabUI.FIELD_NAME,fieldName);
        return getAttributeValue(driver, UserMyAccountCustomerInfoTabUI.FIELD_NAME,"value",fieldName);
    }
    public void clickSaveButton() {
        scrollIntoViewByJS(driver, UserMyAccountCustomerInfoTabUI.SAVE_BUTTON);
        setDelayTime(1);
        clickToElement(driver, UserMyAccountCustomerInfoTabUI.SAVE_BUTTON);
    }

    public boolean checkGenderChosen(WebDriver driver, String valueName) {
        waitForElementsVisible(driver, UserMyAccountCustomerInfoTabUI.GENDER_OPTION,valueName);
        return isElementSelected(driver, UserMyAccountCustomerInfoTabUI.GENDER_OPTION,valueName);
    }
    public String getDataOnField(WebDriver driver, String fieldName) {
        return getAttributeValue(driver, UserMyAccountCustomerInfoTabUI.FIELD_NAME,"value",fieldName);
    }

    public void clickAddressesLink() {
        setDelayTime(1);
        waitForElementClickable(driver,UserMyAccountCustomerInfoTabUI.ADDRESSES_LINK);
        clickToElement(driver, UserMyAccountCustomerInfoTabUI.ADDRESSES_LINK);
    }

    public boolean checkMyaccountCustomerInfDisplay() {
        waitForElementsVisible(driver, UserMyAccountCustomerInfoTabUI.TITLE_PAGE);
        return isElementDisplay(driver, UserMyAccountCustomerInfoTabUI.TITLE_PAGE);
    }
}
