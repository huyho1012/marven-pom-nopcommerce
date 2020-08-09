package NopCommerce.PageObject.User.MyAccount;

import NopCommerce.Interface.User.MyAccount.UserMyAccountAddressTabUI;
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

    public void enterFirstName(String firtNameAddress) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.FIRST_NAME_TEXT_BOX);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.FIRST_NAME_TEXT_BOX,firtNameAddress);
    }
    public void enterLastName(String lastNameAddress) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.LAST_NAME_TEXT_BOX);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.LAST_NAME_TEXT_BOX,lastNameAddress);
    }
    public void enterEmail(String emailAdress) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.EMAIL_TEXT_BOX);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.EMAIL_TEXT_BOX,emailAdress);
    }
    public void enterCompany(String companyAddress) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.COMPANY_TEXT_BOX);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.COMPANY_TEXT_BOX,companyAddress);
    }
    public void enterCity(String cityAddress) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.CITY_TEXT_BOX);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.CITY_TEXT_BOX,cityAddress);
    }
    public void enterAddress1(String Address1) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.ADDRESS1_TEXT_BOX);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.ADDRESS1_TEXT_BOX,Address1);
    }
    public void enterAddress2(String Address2) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.ADDRESS2_TEXT_BOX);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.ADDRESS2_TEXT_BOX,Address2);
    }
    public void enterZipCode(String zipCode) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.ZIP_CODE_TEXT_BOX);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.ZIP_CODE_TEXT_BOX,zipCode);
    }
    public void enterPhoneNumber(String phoneNumber) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.PHONE_NUMBER_TEXT_BOX);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.PHONE_NUMBER_TEXT_BOX,phoneNumber);
    }
    public void enterFaxNumber(String taxNumber) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.FAX_NUMBER_TEXT_BOX);
        sendKeyToElement(driver,UserMyAccountAddressTabUI.FAX_NUMBER_TEXT_BOX,taxNumber);
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

    public String checkEmailDisplay(WebDriver driver) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.EMAIL_DATA_FIELD);
        String text =  getTextElement(driver,UserMyAccountAddressTabUI.EMAIL_DATA_FIELD);
        String[] word = text.split("\\s");
        return word[1];
    }
    public String checkFullNameDisplay(WebDriver driver) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.FULL_NAME_FILED);
        return getTextElement(driver,UserMyAccountAddressTabUI.FULL_NAME_FILED);
    }

    public String checkPhoneNumber(WebDriver driver) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.PHONE_DATA_FIELD);
        String text =  getTextElement(driver,UserMyAccountAddressTabUI.PHONE_DATA_FIELD);
        String[] word = text.split("\\s");
        System.out.println(word[2]);
        return word[2];
    }

    public String checkFaxNumber(WebDriver driver) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.FAX_DATA_FIELD);
        String text =  getTextElement(driver,UserMyAccountAddressTabUI.FAX_DATA_FIELD);
        String[] word = text.split("\\s");
        System.out.println(word[2]);
        return word[2];
    }

    public String checkAddress1Display(WebDriver driver) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.ADDRESS1_DATA_FIELD);
        return getTextElement(driver,UserMyAccountAddressTabUI.ADDRESS1_DATA_FIELD);
    }

    public String checkAddress2Display(WebDriver driver) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.ADDRESS2_DATA_FIELD);
        return getTextElement(driver,UserMyAccountAddressTabUI.ADDRESS2_DATA_FIELD);
    }

    public String checkCityStateZipCodeDisplay(WebDriver driver) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.CITY_STATE_ZIP_FIELD);
        return getTextElement(driver,UserMyAccountAddressTabUI.CITY_STATE_ZIP_FIELD);
    }

    public String checkCompanyName(WebDriver driver) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.COMPANY_NAME_FIELD);
        return getTextElement(driver,UserMyAccountAddressTabUI.COMPANY_NAME_FIELD);
    }

    public String checkCountry(WebDriver driver) {
        waitForElementVisible(driver,UserMyAccountAddressTabUI.COUNTRY_FIELD);
        return getTextElement(driver,UserMyAccountAddressTabUI.COUNTRY_FIELD);
    }
}
