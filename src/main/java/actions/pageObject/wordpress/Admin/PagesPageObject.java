package actions.pageObject.wordpress.Admin;


import actions.pageObject.wordpress.common.CommonPageObject;
import org.openqa.selenium.WebDriver;

public class PagesPageObject extends CommonPageObject {
    WebDriver driver;
    public PagesPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }
}
