package actions.pageObject.bankGuru;

import actions.common.bankGuru.AbstractPageBankGuru;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends AbstractPageBankGuru {
    WebDriver driver;
    public LoginPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickHereLink() {
    }
}
