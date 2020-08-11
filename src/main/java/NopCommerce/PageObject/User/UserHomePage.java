package NopCommerce.PageObject.User;

import NopCommerce.Interface.User.HomePageUI;
import NopCommerce.PageObject.User.MyAccount.UserMyAccountCustomerInfoTab;
import actions.common.functionHelper.AbstractPage;
import org.openqa.selenium.WebDriver;

public class UserHomePage extends AbstractPage {
    WebDriver driver;

    public UserHomePage(WebDriver webDriver) {
        driver = webDriver;
    }

    public UserRegisterPage clickRegisterButton() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
        return PageGenratorManager.getRegisterPage(driver);
    }

    public UserLoginPage clickLoginIcon() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver,HomePageUI.LOGIN_LINK);
        return PageGenratorManager.getUserLoginPage(driver);
    }

    public boolean checkLoginSuccess() {
        setDelayTime(1);
        waitForElementsVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public UserMyAccountCustomerInfoTab clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
        return PageGenratorManager.getMyAccountCustomerInfoTab(driver);
    }

    public void clickToProduct() {
        waitForElementClickable(driver, HomePageUI.LINK_PRODUCT);
        clickToElement(driver,HomePageUI.LINK_PRODUCT);
    }

    public void clickToAddNewReview() {
        setDelayTime(2);
        waitForElementClickable(driver, HomePageUI.ADD_NEW_REVIEW);
        clickToElement(driver,HomePageUI.ADD_NEW_REVIEW);
    }

    public void enterTitleReview(String reviewTitle) {
        waitForElementClickable(driver, HomePageUI.REVIEW_TITLE_INPUT);
        sendKeyToElement(driver,HomePageUI.REVIEW_TITLE_INPUT,reviewTitle);
    }
    public void enterReviewText(String reviewTitle) {
        waitForElementClickable(driver, HomePageUI.REVIEW_TEXT);
        sendKeyToElement(driver,HomePageUI.REVIEW_TEXT,reviewTitle);
    }

    public void chooseRating(String valueItem) {
        waitForElementClickable(driver, HomePageUI.OPTION_RATING,valueItem);
        clickToElement(driver,HomePageUI.OPTION_RATING,valueItem);
    }

    public void clickSubmitReview() {
        waitForElementClickable(driver, HomePageUI.SUBMIT_REVIEW);
        clickToElement(driver,HomePageUI.SUBMIT_REVIEW);
    }

    public String getSuccessfullAddReview() {
        waitForElementClickable(driver, HomePageUI.SUCCESS_RESULT);
        return getTextElement(driver,HomePageUI.SUCCESS_RESULT);
    }

    public boolean checkTitieReviewDisplay(String titleReview) {
        waitForElementClickable(driver, HomePageUI.TITLE_REVIEW,titleReview.toLowerCase());
        return isElementDisplay(driver, HomePageUI.TITLE_REVIEW,titleReview.toLowerCase());
    }
    public boolean checkContenReviewDisplay(String contentReview) {
        waitForElementClickable(driver, HomePageUI.CONTENT_REVIEW,contentReview.toLowerCase());
        return isElementDisplay(driver, HomePageUI.CONTENT_REVIEW,contentReview.toLowerCase());
    }
}
