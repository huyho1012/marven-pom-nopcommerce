package NopCommerce.PageObject;

import actions.common.functionHelper.AbstractPage;
import org.openqa.selenium.WebDriver;

public class PageGenratorManager extends AbstractPage {

    public static HomePage getHomepage(WebDriver driver){
        return new HomePage(driver);
    }
    public static RegisterPage getRegisterPage(WebDriver driver){
        return new RegisterPage(driver);
    }
}
