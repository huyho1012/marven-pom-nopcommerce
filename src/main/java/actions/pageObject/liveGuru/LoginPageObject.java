package actions.pageObject.liveGuru;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.liveGuru.LoginPageUI;

public class LoginPageObject extends AbstractPage {
    private final WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void clickToCreateAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREATE_MY_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_MY_ACCOUNT_BUTTON);
    }
}
