package actions.pageObject.wordpress.common;


import actions.common.AbstractTest;
import actions.pageObject.wordpress.Admin.DashboardPageObject;
import actions.pageObject.wordpress.User.HomePageObject;
import actions.pageObject.wordpress.User.SearchResultPageObject;
import interfaces.wordPress.Common.CommonPageUI;
import interfaces.wordPress.Common.MenuUI;
import interfaces.wordPress.User.HomePageUI;
import org.openqa.selenium.WebDriver;


public class CommonPageObject extends AbstractTest {
    // Cách 2 áp dụng cho TH Menu nhiều trang
    public void openMenuPage(WebDriver driver, String menuItem) {
        waitForElementClickable(driver, MenuUI.DYNAMIC_MENU_LINK, menuItem);
        clickToElement(driver, MenuUI.DYNAMIC_MENU_LINK, menuItem);
    }

    public HomePageObject openUserHomePage(WebDriver driver){
        openPage(driver, CommonPageUI.USER_WORD_PRESS_LINK);
        return PageGeneratorManager.getHomeUserPage(driver);
    }
    public DashboardPageObject openAdminHomePage(WebDriver driver){
        openPage(driver, CommonPageUI.ADMIN_WORD_PRESS_LINK);
        return PageGeneratorManager.getDashboardAdminPage(driver);
    }

    public SearchResultPageObject inputDataOnSearchBoxInUserPage(WebDriver driver, String value){
        waitForElementVisible(driver, HomePageUI.SEARCH_ICON);
        clickToElement(driver,HomePageUI.SEARCH_ICON);
        sendKeyToElement(driver,HomePageUI.SEARCH_FIELD,value);
        clickToElement(driver,HomePageUI.SEARCH_BUTTON);
        return PageGeneratorManager.getSearchResultUserPage(driver);
    }

    public boolean isNewPostDisplayOnLastestPost(WebDriver driver, String titlePage, String categoryName, String dateCreated){
        waitForElementVisible(driver, HomePageUI.CATEGORY_TITLE_DATE, titlePage,categoryName,dateCreated);
        return isElementDisplay(driver, HomePageUI.CATEGORY_TITLE_DATE, titlePage,categoryName,dateCreated);
    }
    public boolean isPostImageDisplayATitlePost(WebDriver driver,String titlePost, String featureImage){
        featureImage = featureImage.split("\\.")[0].toLowerCase();
        waitForElementVisible(driver, HomePageUI.DYNAMIC_POST_AVATAR, titlePost,featureImage);
        return (isElementDisplay(driver, HomePageUI.DYNAMIC_POST_AVATAR, titlePost,featureImage) && isImageLoaded(driver,HomePageUI.DYNAMIC_POST_AVATAR,titlePost,featureImage));
    }

    public boolean isSuccessMessage(WebDriver driver, String value){
        waitForElementVisible(driver,CommonPageUI.DYNAMIC_MESSAGE,value);
        return isElementDisplay(driver,CommonPageUI.DYNAMIC_MESSAGE,value);
    }

    public boolean areDataDisplayOnColumn(WebDriver driver, String columnName, String values) {
        waitForElementsVisible(driver, CommonPageUI.DYNAMIC_DATA_ON_COLUMN,columnName,values);
        return isElementDisplay(driver, CommonPageUI.DYNAMIC_DATA_ON_COLUMN,columnName,values);
    }
}
