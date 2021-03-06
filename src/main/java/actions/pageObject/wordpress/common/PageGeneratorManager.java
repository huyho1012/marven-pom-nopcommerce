package actions.pageObject.wordpress.common;

import actions.pageObject.wordpress.Admin.*;
import actions.pageObject.wordpress.User.HomePageObject;
import actions.pageObject.wordpress.User.PostDetailPageObject;
import actions.pageObject.wordpress.User.SearchResultPageObject;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static LoginPageObject getLoginAdminPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static MediaPageObject getMediaAdminPage(WebDriver driver){
        return new MediaPageObject(driver);
    }
    public static DashboardPageObject getDashboardAdminPage(WebDriver driver){
        return new DashboardPageObject(driver);
    }
    public static PagesPageObject getPagesAdminPage(WebDriver driver){
        return new PagesPageObject(driver);
    }
    public static PostPageObject getPostAdminPage(WebDriver driver){
        return new PostPageObject(driver);
    }
    public static PostEditorPageObject getPostDetailAdminPage(WebDriver driver){
        return new PostEditorPageObject(driver);
    }
    public static PostDetailPageObject getPostDetailUserPage(WebDriver driver){
        return new PostDetailPageObject(driver);
    }
    public static HomePageObject getHomeUserPage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static SearchResultPageObject getSearchResultUserPage(WebDriver driver){
        return new SearchResultPageObject(driver);
    }
}
