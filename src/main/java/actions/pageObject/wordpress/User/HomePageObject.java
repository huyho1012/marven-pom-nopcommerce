package actions.pageObject.wordpress.User;

import actions.pageObject.wordpress.common.CommonPageObject;
import actions.pageObject.wordpress.common.PageGeneratorManager;
import interfaces.wordPress.User.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends CommonPageObject {
    WebDriver driver;
    public HomePageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public PostDetailPageObject clickToLDetailWithTitle(WebDriver driver,String titlePost) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_POST_TITLE, titlePost);
        clickToElement(driver, HomePageUI.DYNAMIC_POST_TITLE, titlePost);
        return PageGeneratorManager.getPostDetailUserPage(driver);
    }
}
