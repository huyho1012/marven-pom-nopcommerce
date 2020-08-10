package NopCommerce.PageObject.User.MyAccount;

import NopCommerce.Interface.User.MyAccount.UserMyAccountAddressTabUI;
import NopCommerce.Interface.User.MyAccount.UserMyAccountCustomerInfoTabUI;
import NopCommerce.PageObject.User.PageGenratorManager;
import actions.common.functionHelper.AbstractPage;
import org.openqa.selenium.WebDriver;

public class UserMyAccountAddressTab extends AbstractPage {
    WebDriver driver;
    public UserMyAccountAddressTab(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkAddressTabDisplay() {
        setDelayTime(1);
        waitForElementVisible(driver, UserMyAccountAddressTabUI.TITLE_ADDRESS_TAB);
        return isElementDisplay(driver, UserMyAccountAddressTabUI.TITLE_ADDRESS_TAB);
    }

    public void clicktoNewAddressButton() {
        waitForElementVisible(driver, UserMyAccountAddressTabUI.ADD_ADDRESS_BUTTON);
        clickToElement(driver, UserMyAccountAddressTabUI.ADD_ADDRESS_BUTTON);
    }

    public boolean checkAddNewAddressTabDisplay() {
        setDelayTime(1);
        waitForElementVisible(driver, UserMyAccountAddressTabUI.TITLE_ADD_NEW_ADDRESS_TAB);
        return isElementDisplay(driver, UserMyAccountAddressTabUI.TITLE_ADD_NEW_ADDRESS_TAB);
    }
    public void enterDynamicDataOnAddress(String nameTextBox, String dataValue) {
        waitForElementVisible(driver, UserMyAccountAddressTabUI.DYNAMIC_TEXT_BOX,nameTextBox);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.DYNAMIC_TEXT_BOX,dataValue,nameTextBox);
    }

    public void selectCountry(WebDriver driver, String itemCountry) {
        selectItemOnDropdown(driver,UserMyAccountAddressTabUI.COUNTRY_DROPDOWN,itemCountry);
    }

    public void selectStateCity(WebDriver driver, String itemState) {
        waitForElementInVisible(driver, UserMyAccountAddressTabUI.LOADING_PROCESSING_BAR);
        selectItemOnDropdown(driver,UserMyAccountAddressTabUI.STATE_DROPDOWN,itemState);
    }

    public void clickSaveButton() {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.SAVE_BUTTON);
        clickToElement(driver,UserMyAccountAddressTabUI.SAVE_BUTTON);
    }
    public String getDataOfEmail() {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.DATA_DISPLAY_FIELD,"email");
        String text =  getTextElement(driver,UserMyAccountAddressTabUI.DATA_DISPLAY_FIELD,"email");
        String[] word = text.split("\\s");
        return word[1];
    }

    public String getDataOfPhoneNumber() {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.DATA_DISPLAY_FIELD,"phone");
        String text =  getTextElement(driver,UserMyAccountAddressTabUI.DATA_DISPLAY_FIELD,"phone");
        String[] word = text.split("\\s");
        System.out.println(word[2]);
        return word[2];
    }
    public String getDataOfTaxNumber() {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.DATA_DISPLAY_FIELD,"fax");
        String text =  getTextElement(driver,UserMyAccountAddressTabUI.DATA_DISPLAY_FIELD,"fax");
        String[] word = text.split("\\s");
        System.out.println(word[2]);
        return word[2];
    }
    public String getOtherInfoIsDisplay(String nameField) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.DATA_DISPLAY_FIELD,nameField);
        return getTextElement(driver,UserMyAccountAddressTabUI.DATA_DISPLAY_FIELD,nameField);
    }

    public UserMyAccountChangePassword clickChangePassLink() {
        waitForElementClickable(driver, UserMyAccountCustomerInfoTabUI.CHANGE_PASSWORD_LINK);
        clickToElement(driver,UserMyAccountCustomerInfoTabUI.CHANGE_PASSWORD_LINK);
        return PageGenratorManager.getMyAccountChangePass(driver);
    }
}
