package actions.pageObject.wordpress.Admin;

import actions.pageObject.wordpress.common.CommonPageObject;
import interfaces.wordPress.Admin.DashboardPageUI;
import org.openqa.selenium.WebDriver;


public class DashboardPageObject extends CommonPageObject {
    WebDriver driver;
    public DashboardPageObject(WebDriver mapDriver){
        driver = mapDriver;
    }

    public boolean checkHeaderDisplay() {
        setDelayTime(1);
        return isElementDisplay(driver, DashboardPageUI.headerTitlePage);
    }

    public void clicktoScreenOption() {
        waitForElementClickable(driver,DashboardPageUI.SCREEN_OPTION_BUTTON);
        clickToElement(driver,DashboardPageUI.SCREEN_OPTION_BUTTON);
    }

    public boolean isActivityCheckboxDisplayed() {
        return isElementDisplay(driver,DashboardPageUI.ACTIVITY_CHECK_BOX);
    }

    public boolean isDisplayAllPostSubMeneu() {
        return isElementDisplay(driver,DashboardPageUI.ALL_POST_SUBMENU);
    }

    public boolean isPlansMenuDisplay() {
        return isElementDisplay(driver,DashboardPageUI.MENU_PLANS);
    }

    public boolean isPlansMenuUnDisplay() {
        return isElementUnDisplay(driver,DashboardPageUI.MENU_PLANS);
    }
}
