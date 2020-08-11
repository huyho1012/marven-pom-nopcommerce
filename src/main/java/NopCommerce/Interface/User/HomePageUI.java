package NopCommerce.Interface.User;

public class HomePageUI {
    public static final String REGISTER_LINK = "//a[@class='ico-register']";
    public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
    public static final String LOGIN_LINK = "//a[@class='ico-login']";

    public static final String LINK_PRODUCT = "//a[contains(text(),'Build your own computer')]";
    public static final String ADD_NEW_REVIEW = "//a[contains(text(),'Add your review')]";

    public static final String REVIEW_TITLE_INPUT =  "//input[@class = 'review-title']";
    public static final String REVIEW_TEXT =  "//textarea[@class = 'review-text']";
    public static final String OPTION_RATING =  "//input[@value = '%s']";
    public static final String SUBMIT_REVIEW = "//input[@name = 'add-review']";
    public static final String SUCCESS_RESULT = "//div[@class = 'result']";
    public static final String TITLE_REVIEW = "//div[@class = 'review-title']/strong[contains(text(),'%S')]";
    public static final String CONTENT_REVIEW = "//div[@class = 'review-text']/div[contains(text(),'%S')]";
}
