package actions.pageObject.wordpress.Admin;

import actions.pageObject.wordpress.common.CommonPageObject;
import actions.pageObject.wordpress.common.PageGeneratorManager;
import interfaces.wordPress.Admin.PostEditorPageUI;
import org.openqa.selenium.WebDriver;

public class PostEditorPageObject extends CommonPageObject {
    WebDriver driver;
    public PostEditorPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void inputToPostContent(String postContent) {
        switchToFrameOrIFrame(driver, PostEditorPageUI.FRAME);
        waitForElementVisible(driver,PostEditorPageUI.POST_CONTENT_TEXT_AREA);
        sendKeyToElement(driver,PostEditorPageUI.POST_CONTENT_TEXT_AREA,postContent);
        switchToDefaultFrame(driver);
    }

    public void inputToPostTitle(String titlePost) {
        waitForElementsVisible(driver, PostEditorPageUI.TITLE_POST_TEXT_BOX);
        sendKeyToElement(driver, PostEditorPageUI.TITLE_POST_TEXT_BOX,titlePost);
    }

    public PostPageObject clickToDeletePost() {
        return PageGeneratorManager.getPostAdminPage(driver);
    }

    public void selectToCategory(String cateName) {
        waitForElementClickable(driver,PostEditorPageUI.CATEGORY_CHECK_BOX,cateName);
        scrollIntoViewByJS(driver,PostEditorPageUI.CATEGORY_CHECK_BOX,cateName);
        clickToElementByJS(driver,PostEditorPageUI.CATEGORY_CHECK_BOX,cateName);
    }
    public void inputToTagTextBox(String tagName) {
        waitForElementVisible(driver,PostEditorPageUI.TAG_TEXT_BOX);
        sendKeyToElement(driver,PostEditorPageUI.TAG_TEXT_BOX,tagName);
    }

    public void clickToTagButton() {
        waitForElementClickable(driver,PostEditorPageUI.ADD_TAG_BUTTON);
        clickToElement(driver,PostEditorPageUI.ADD_TAG_BUTTON);
    }

    public void clickToSetImageLink() {
        waitForElementClickable(driver,PostEditorPageUI.SET_FEATURE_IMAGE_LINK);
        clickToElement(driver,PostEditorPageUI.SET_FEATURE_IMAGE_LINK);
    }

    public void uploadToUploadFileTab() {
        waitForElementClickable(driver,PostEditorPageUI.UPLOAD_BUTTON);
        clickToElement(driver,PostEditorPageUI.UPLOAD_BUTTON);
    }

    public void clickToSetFeatureImageButton() {
        waitForElementClickable(driver,PostEditorPageUI.SET_FEATURE_IMAGE_BUTTON);
        clickToElement(driver,PostEditorPageUI.SET_FEATURE_IMAGE_BUTTON);
    }

    public void clickToPublishButton() {
        waitForElementClickable(driver,PostEditorPageUI.PUBLISH_BUTTON);
        clickToElementByJS(driver,PostEditorPageUI.PUBLISH_BUTTON);
    }

    public boolean checkFeatureImageDisplayOn(String imageURL) {
        String[] files = imageURL.split("\\.");
        waitForElementVisible(driver,PostEditorPageUI.FEATURE_IMAGE,files[0]);
        return isElementDisplay(driver,PostEditorPageUI.FEATURE_IMAGE,files[0]);
    }

    public void deselectToCategory(String newCategory) {
        waitForElementClickable(driver,PostEditorPageUI.CATEGORY_CHECK_BOX,newCategory);
        scrollIntoViewByJS(driver,PostEditorPageUI.CATEGORY_CHECK_BOX,newCategory);
        clickToElementByJS(driver,PostEditorPageUI.CATEGORY_CHECK_BOX,newCategory);
    }

    public void clickToUpdateButton() {
        waitForElementClickable(driver,PostEditorPageUI.PUBLISH_BUTTON);
        clickToElementByJS(driver,PostEditorPageUI.PUBLISH_BUTTON);
    }

    public void clickToDeleteOldTagName(String newPostTag) {
        waitForElementClickable(driver,PostEditorPageUI.REMOVE_TAGGING_BUTTON,newPostTag);
        clickToElement(driver,PostEditorPageUI.REMOVE_TAGGING_BUTTON,newPostTag);
    }
}
