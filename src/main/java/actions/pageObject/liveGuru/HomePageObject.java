package actions.pageObject.liveGuru;

import actions.common.functionHelper.AbstractPage;
import interfaces.liveGuru.HomePageUI;
import org.openqa.selenium.WebDriver;


public class HomePageObject extends AbstractPage {
    private final WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void clickMyAcountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
    }
}
