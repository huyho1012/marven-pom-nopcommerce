package actions.pageObject.wordpress.Admin;

import actions.pageObject.wordpress.common.CommonPageObject;
import interfaces.wordPress.Admin.MediaPageUI;
import org.openqa.selenium.WebDriver;

public class MediaPageObject extends CommonPageObject {
    WebDriver driver;
    public MediaPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }

    public void clickToAddNewButton() {
        waitForElementClickable(driver, MediaPageUI.ADD_NEW_BUTTON);
        clickToElement(driver,MediaPageUI.ADD_NEW_BUTTON);
    }
}
