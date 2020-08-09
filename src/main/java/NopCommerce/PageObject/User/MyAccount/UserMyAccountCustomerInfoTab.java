package NopCommerce.PageObject.User.MyAccount;


import NopCommerce.Interface.User.MyAccount.UserMyAccountCustomerInfoTabUI;
import actions.common.functionHelper.AbstractPage;
import org.openqa.selenium.WebDriver;

public class UserMyAccountCustomerInfoTab extends AbstractPage {
    WebDriver driver;
    public UserMyAccountCustomerInfoTab(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkDisplayMyAccountPage() {
        waitForElementsVisible(driver, UserMyAccountCustomerInfoTabUI.TITLE_PAGE);
        return isElementDisplay(driver, UserMyAccountCustomerInfoTabUI.TITLE_PAGE);
    }
    public void chooseGender(String value) {
        waitForElementsVisible(driver, UserMyAccountCustomerInfoTabUI.GENDER_OPTION,value);
        clickToElement(driver, UserMyAccountCustomerInfoTabUI.GENDER_OPTION,value);
    }

    public void enterDataToDynamicField(WebDriver driver,String fieldName, String value) {
        waitForElementsVisible(driver, UserMyAccountCustomerInfoTabUI.FIELD_NAME,fieldName);
        sendKeyToElement(driver, UserMyAccountCustomerInfoTabUI.FIELD_NAME,value,fieldName);
    }

    public void chooseBirthday(WebDriver driver, String dayItem, String monthItem, String yearItem, String dayDropdown, String monthDropdown,String yearDropdown) {
        selectItemOnDropdown(driver, UserMyAccountCustomerInfoTabUI.SELECTED_DAY_DROPDOWN,dayItem,dayDropdown);
        selectItemOnDropdown(driver, UserMyAccountCustomerInfoTabUI.SELECTED_DAY_DROPDOWN,monthItem,monthDropdown);
        selectItemOnDropdown(driver, UserMyAccountCustomerInfoTabUI.SELECTED_DAY_DROPDOWN,yearItem,yearDropdown);
    }

    public boolean checkDataDisplayonDynamicField(WebDriver driver, String fieldName, String dataInput) {
        waitForElementsVisible(driver, UserMyAccountCustomerInfoTabUI.FIELD_NAME,fieldName);
        return getAttributeValue(driver, UserMyAccountCustomerInfoTabUI.FIELD_NAME,"value",fieldName).equals(dataInput);
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

    public String  getDataOnField(WebDriver driver, String fieldName) {
        return getAttributeValue(driver, UserMyAccountCustomerInfoTabUI.FIELD_NAME,"value",fieldName);
    }


    public void clickAddressesLink() {
        setDelayTime(1);
        waitForElementClickable(driver,UserMyAccountCustomerInfoTabUI.ADDRESSES_LINK);
        clickToElement(driver, UserMyAccountCustomerInfoTabUI.ADDRESSES_LINK);
//        return PageGenratorManager.getMyAccountAddressTab(driver);
    }
}
