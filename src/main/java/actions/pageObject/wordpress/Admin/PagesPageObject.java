package actions.pageObject.wordpress.Admin;

import org.openqa.selenium.WebDriver;
import pageObject.wordpress.common.CommonPageObject;

public class PagesPageObject extends CommonPageObject {
    WebDriver driver;
    public PagesPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }
}
