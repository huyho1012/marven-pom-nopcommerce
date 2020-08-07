package actions.pageObject.liveGuru;

import actions.common.functionHelper.AbstractPage;
import interfaces.liveGuru.MyDashboardPageUI;
import org.openqa.selenium.WebDriver;

public class MyDashboardPageObject extends AbstractPage {
    private final WebDriver driver;
    public MyDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getWelcomMessage() {
       waitForElementVisible(driver, MyDashboardPageUI.MSG_WELCOME_PAGE);
       return getTextElement(driver, MyDashboardPageUI.MSG_WELCOME_PAGE);
    }
}
