package actions.pageObject.liveGuru;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.liveGuru.HomePageUI;

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
