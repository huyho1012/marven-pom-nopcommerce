package actions.pageObject.wordpress.User;

import actions.pageObject.wordpress.common.CommonPageObject;
import org.openqa.selenium.WebDriver;

public class SearchResultPageObject extends CommonPageObject {
    WebDriver driver;
    public SearchResultPageObject(WebDriver webDriver){
        driver = webDriver;
    }
}
