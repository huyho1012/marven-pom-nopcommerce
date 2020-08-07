package NopCommerce.PageObject;

import NopCommerce.Interface.HomePageUI;
import actions.common.functionHelper.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    WebDriver driver;

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
    }

    public RegisterPage clickRegisterButton(WebDriver driver) {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
        return PageGenratorManager.getRegisterPage(driver);
    }
}
