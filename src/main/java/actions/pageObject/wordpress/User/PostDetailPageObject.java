package actions.pageObject.wordpress.User;

import actions.pageObject.wordpress.common.CommonPageObject;
import interfaces.wordPress.User.PostDetailPageUI;
import org.openqa.selenium.WebDriver;

public class PostDetailPageObject extends CommonPageObject {
    WebDriver driver;
    public PostDetailPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean isPostTitleDisplay(WebDriver driver, String newPostTitle) {
        waitForElementVisible(driver, PostDetailPageUI.TITLE_POST,newPostTitle);
        return isElementDisplay(driver, PostDetailPageUI.TITLE_POST,newPostTitle);
    }
    public boolean isCategoryDisplay(WebDriver driver, String newCategory) {
        waitForElementVisible(driver, PostDetailPageUI.CATEGORY_POST,newCategory);
        return isElementDisplay(driver, PostDetailPageUI.CATEGORY_POST,newCategory);
    }
    public boolean isAuthorNameDisplay(WebDriver driver, String authorName) {
        waitForElementVisible(driver, PostDetailPageUI.AUTHOR_POSt,authorName);
        return isElementDisplay(driver, PostDetailPageUI.AUTHOR_POSt,authorName);
    }
    public boolean isPostTagDisplay(WebDriver driver, String newTagName) {
        waitForElementVisible(driver, PostDetailPageUI.TAG_POSt,newTagName);
        return isElementDisplay(driver, PostDetailPageUI.TAG_POSt,newTagName);
    }
    public boolean isPostContentDisplay(WebDriver driver, String newPostContent) {
        waitForElementVisible(driver, PostDetailPageUI.POST_CONTENT,newPostContent);
        return isElementDisplay(driver, PostDetailPageUI.POST_CONTENT,newPostContent);
    }
    public boolean isCreatedDateDisplay(WebDriver driver, String createdDate) {
        waitForElementVisible(driver, PostDetailPageUI.CREATED_DATE_POSt,createdDate);
        return isElementDisplay(driver, PostDetailPageUI.CREATED_DATE_POSt,createdDate);
    }

    public boolean isImageDisplay(WebDriver driver, String featureImage) {
        String[] files = featureImage.split("\\.");
        waitForElementVisible(driver, PostDetailPageUI.IMAGE_POST,files[0]);
        return isElementDisplay(driver, PostDetailPageUI.IMAGE_POST,files[0]);
    }
}
