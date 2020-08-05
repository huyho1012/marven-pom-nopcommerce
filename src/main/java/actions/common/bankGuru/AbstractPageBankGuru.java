package actions.common.bankGuru;


import actions.common.AbstractPage;
import interfaces.bankGuru.CustomerPageUI;
import org.openqa.selenium.WebDriver;

public class AbstractPageBankGuru extends AbstractPage {
    public void inputToDynamicTextBox(WebDriver driver, String textBoxName, String inputValue){
        waitForElementVisible(driver, CustomerPageUI.DYNAMIC_TEXT_FIELD,textBoxName);
        if(textBoxName.equals("dob")){
            removeAttributeInDOM(driver,CustomerPageUI.DYNAMIC_TEXT_FIELD,"type",textBoxName);
            setDelayTime(1);
        }
        sendKeyToElement(driver, CustomerPageUI.DYNAMIC_TEXT_FIELD,inputValue,textBoxName);
    }
    public void inputToDynamicTextArea(WebDriver driver, String textAreaName,String inputValue){
        waitForElementVisible(driver, CustomerPageUI.DYNAMIC_TEXT_AREA,textAreaName);
        sendKeyToElement(driver, CustomerPageUI.DYNAMIC_TEXT_AREA,inputValue,textAreaName);
    }
    public void clickToDynamicButton(WebDriver driver, String buttonName){
        waitForElementClickable(driver, CustomerPageUI.DYNAMIC_BUTTON,buttonName);
        scrollIntoViewByJS(driver,CustomerPageUI.DYNAMIC_BUTTON,buttonName);
        clickToElement(driver, CustomerPageUI.DYNAMIC_BUTTON,buttonName);
    }
    public void clickToDynamicRadioButton(WebDriver driver, String radioName){
        waitForElementClickable(driver, CustomerPageUI.DYNAMIC_RADIO_BUTTON,radioName);
        clickToElement(driver, CustomerPageUI.DYNAMIC_RADIO_BUTTON,radioName);
    }
    public void clickToDynamicLink(WebDriver driver, String valueLink){
        waitForElementVisible(driver, CustomerPageUI.DYNAMIC_MENU,valueLink);
        clickToElement(driver, CustomerPageUI.DYNAMIC_MENU,valueLink);
    }
    public boolean isDynamicMessageDisplay(WebDriver driver, String messageName){
        waitForElementVisible(driver, CustomerPageUI.DYNAMIC_TITLE_PAGE,messageName);
        return isElementDisplay(driver, CustomerPageUI.DYNAMIC_TITLE_PAGE,messageName);
    }
    public String getDataOnDynamicColumn(WebDriver driver, String columnName){
        waitForElementVisible(driver, CustomerPageUI.DATA_BY_DYNAMIC_COLUMN,columnName);
        return getTextElement(driver,CustomerPageUI.DATA_BY_DYNAMIC_COLUMN,columnName);
    }
}
