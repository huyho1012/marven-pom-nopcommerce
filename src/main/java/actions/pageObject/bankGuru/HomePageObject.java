package actions.pageObject.bankGuru;

import actions.common.bankGuru.AbstractPageBankGuru;
import interfaces.bankGuru.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends AbstractPageBankGuru {
    WebDriver driver;
    public HomePageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean isWelcomeMessageDisplay() {
        waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE);
        return isElementDisplay(driver, HomePageUI.WELCOME_MESSAGE);
    }
}
