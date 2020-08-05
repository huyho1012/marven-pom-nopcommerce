package actions.pageObject.bankGuru;


import actions.common.bankGuru.AbstractPageBankGuru;
import org.openqa.selenium.WebDriver;

public class CustomerPageObject extends AbstractPageBankGuru {
    WebDriver driver;
    public CustomerPageObject(WebDriver webDriver){
        driver = webDriver;
    }
}

