package testcases.wordPress.Posts;

import java.io.IOException;
import actions.browserFactory.BrowserDriver;
import actions.browserFactory.DriverManager;
import actions.common.functionHelper.Constants;
import actions.common.functionHelper.ParseCustomer;
import actions.pageObject.wordpress.Admin.DashboardPageObject;
import actions.pageObject.wordpress.Admin.LoginPageObject;
import actions.pageObject.wordpress.Admin.PostEditorPageObject;
import actions.pageObject.wordpress.Admin.PostPageObject;
import actions.pageObject.wordpress.User.HomePageObject;
import actions.pageObject.wordpress.User.PostDetailPageObject;
import actions.pageObject.wordpress.User.SearchResultPageObject;
import actions.pageObject.wordpress.common.CommonPageObject;
import actions.pageObject.wordpress.common.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Post_Admin_Create_View_Edit extends CommonPageObject {
    DriverManager driverManager;
    WebDriver driver;

    LoginPageObject loginAdminPage;
    DashboardPageObject dashboardAdminPage;
    PostPageObject postAdminPage;
    PostEditorPageObject postEditorAdminPage;
    HomePageObject homeUserPage;
    PostDetailPageObject postDetailUserPage;
    SearchResultPageObject searchResultUserPage;
    ParseCustomer data;

    String today = getToday();
    String authorName = "Automation FC";
    String newPostTitle ="[HUY_HO] Post Title" +randomNumber();
    String newPostContent= "TEST lIVE CODING _ HUYHO";
    String newPostTag ="new_tag_java_coding"+ randomNumber();
    String featureImage = "batman.jpg";
    String newCategory ="JAVASCRIPT";

    String updatedPostTitle = "[HUY_HO] Updated Post" +randomNumber();
    String updatedPostContent = "SELENIUM Test coding" +randomNumber();
    String updatedPostTag ="edit_tag_java_coding"+ randomNumber();
    String updateCategory ="DATA DRIVEN TESTING FRAMEWORK";


    @Parameters("browser")
    @BeforeTest
    public void preCondition(String browserName) throws IOException {
    log.info("Precondition -Step 01 - Open browser");
    data = ParseCustomer.getNewCustomerData(Constants.CUSTOMER_JSON_FILE);
    driverManager = BrowserDriver.getBrowser(browserName);
    driver = driverManager.getDriver();
    loginAdminPage = PageGeneratorManager.getLoginAdminPage(driver);

    log.info("Precondition -Step 02 - Enter username/Email");
    loginAdminPage.inputUserName("automationeditor");

    log.info("Precondition -Step 03 - Click button Continue");
    loginAdminPage.clickToContinueButton();

    log.info("Precondition -Step 04 - Enter password");
    loginAdminPage.inputPassword("automationfc");

    log.info("Precondition -Step 05 - Click button Login");
    dashboardAdminPage = loginAdminPage.clickToDashboard(driver);

    log.info("Precondition -Step 06 - Check Login success");
    }
    @Test
    public void Testcase_Post_01_CreateNewPost_At_Admin() {
        dashboardAdminPage.openMenuPage(driver, "Posts");
        postAdminPage = PageGeneratorManager.getPostAdminPage(driver);
        postEditorAdminPage = postAdminPage.clickAddNewButton();
        postEditorAdminPage.inputToPostTitle(newPostTitle);
        postEditorAdminPage.inputToPostContent(newPostContent);
        postEditorAdminPage.selectToCategory(newCategory);
        postEditorAdminPage.inputToTagTextBox(newPostTag);
        postEditorAdminPage.clickToTagButton();
        postEditorAdminPage.clickToSetImageLink();
        postEditorAdminPage.uploadToUploadFileTab();
        postEditorAdminPage.uploadMultipleFiles(driver, featureImage);
        postEditorAdminPage.clickToSetFeatureImageButton();
        verifyTrue(postEditorAdminPage.checkFeatureImageDisplayOn(featureImage));
        postEditorAdminPage.clickToPublishButton();
        verifyTrue(postEditorAdminPage.isSuccessMessage(driver, "Post published"));
        postEditorAdminPage.openMenuPage(driver, "Posts");
        postAdminPage = PageGeneratorManager.getPostAdminPage(driver);
        postAdminPage.inputToSearchTextBox(newPostTitle);
        postAdminPage.clickToSearchButton();
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"title",newPostTitle));
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"categories",newCategory));
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"author ",authorName));
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"tags",newPostTag));
        homeUserPage = postAdminPage.openUserHomePage(driver);
        verifyTrue(homeUserPage.isNewPostDisplayOnLastestPost(driver,newPostTitle,newCategory, today));
        postDetailUserPage = homeUserPage.clickToLDetailWithTitle(driver,newPostTitle);
        verifyTrue(postDetailUserPage.isPostTitleDisplay(driver,newPostTitle));
        verifyTrue(postDetailUserPage.isCategoryDisplay(driver,newCategory));
        verifyTrue(postDetailUserPage.isAuthorNameDisplay(driver,authorName));
        verifyTrue(postDetailUserPage.isPostTagDisplay(driver,newPostTag));
        verifyTrue(postDetailUserPage.isPostContentDisplay(driver,newPostContent));
        verifyTrue(postDetailUserPage.isCreatedDateDisplay(driver,today));
        verifyTrue(postDetailUserPage.isImageDisplay(driver,featureImage));

        searchResultUserPage= postDetailUserPage.inputDataOnSearchBoxInUserPage(driver,newPostTitle);
        verifyTrue(searchResultUserPage.isNewPostDisplayOnLastestPost(driver,newPostTitle,newCategory, today));

    }
    @Test
    public void Testcase_Post_02_EditPost_At_Admin(){
        dashboardAdminPage = searchResultUserPage.openAdminHomePage(driver);
        postEditorAdminPage.openMenuPage(driver, "Posts");
        postAdminPage = PageGeneratorManager.getPostAdminPage(driver);
        postAdminPage.inputToSearchTextBox(newPostTitle);
        postAdminPage.clickToSearchButton();
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"title",newPostTitle));
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"categories",newCategory));
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"author ",authorName));
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"tags",newPostTag));
        postEditorAdminPage =  postAdminPage.clickToPostDetailByTitleName(newPostTitle);

        postEditorAdminPage.inputToPostTitle(updatedPostTitle);
        postEditorAdminPage.inputToPostContent(updatedPostContent);
        postEditorAdminPage.deselectToCategory(newCategory);
        postEditorAdminPage.selectToCategory(updateCategory);
        postEditorAdminPage.inputToTagTextBox(updatedPostTag);
        postEditorAdminPage.clickToTagButton();
        postEditorAdminPage.clickToDeleteOldTagName(newPostTag);

        postEditorAdminPage.clickToUpdateButton();
        verifyTrue(postEditorAdminPage.isSuccessMessage(driver,"Post updated"));
        postEditorAdminPage.openMenuPage(driver, "Posts");
        postAdminPage = PageGeneratorManager.getPostAdminPage(driver);
        postAdminPage.inputToSearchTextBox(updatedPostTitle);
        postAdminPage.clickToSearchButton();
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"title",updatedPostTitle));
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"categories",updateCategory));
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"author ",authorName));
        verifyTrue(postAdminPage.areDataDisplayOnColumn(driver,"tags",updatedPostTag));

        homeUserPage = postAdminPage.openUserHomePage(driver);
        verifyTrue(homeUserPage.isNewPostDisplayOnLastestPost(driver,updatedPostTitle,updateCategory, today));
        postDetailUserPage = homeUserPage.clickToLDetailWithTitle(driver,updatedPostTitle);
        verifyTrue(postDetailUserPage.isPostTitleDisplay(driver,updatedPostTitle));
        verifyTrue(postDetailUserPage.isCategoryDisplay(driver,updateCategory));
        verifyTrue(postDetailUserPage.isAuthorNameDisplay(driver,authorName));
        verifyTrue(postDetailUserPage.isPostTagDisplay(driver,updatedPostTag));
        verifyTrue(postDetailUserPage.isPostContentDisplay(driver,updatedPostContent));
        verifyTrue(postDetailUserPage.isCreatedDateDisplay(driver,today));
        verifyTrue(postDetailUserPage.isImageDisplay(driver,featureImage));

        searchResultUserPage= postDetailUserPage.inputDataOnSearchBoxInUserPage(driver,updatedPostTitle);
        verifyTrue(searchResultUserPage.isNewPostDisplayOnLastestPost(driver,updatedPostTitle,updateCategory, today));
  }
    @AfterClass
    public void finishTestcase(){
        log.info("Finish - Close browser");
        closeBrowserAndDriver(driver);
    }
}
