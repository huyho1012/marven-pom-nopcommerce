package actions.pageObject.wordpress.Admin;

import org.openqa.selenium.WebDriver;
import pageObject.wordpress.common.CommonPageObject;
import pageUI.wordPress.Admin.MediaPageUI;

public class MediaPageObject extends CommonPageObject {
    WebDriver driver;
    public MediaPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }

    public void clickToAddNewButton() {
        waitForElementClickable(driver,MediaPageUI.ADD_NEW_BUTTON);
        clickToElement(driver,MediaPageUI.ADD_NEW_BUTTON);
    }
}
