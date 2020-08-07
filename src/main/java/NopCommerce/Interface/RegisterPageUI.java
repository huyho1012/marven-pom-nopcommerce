package NopCommerce.Interface;

public class RegisterPageUI {
    public static final String TITLE_PAGE = "//div[@class ='page-title']/h1[text()='Register']";
    public static final String VALIDATE_ERROR_FIELD = "//span[@id='%s-error']";
    public static final String REGISTER_BUTTON = "//input[@id ='register-button']";

    public static final String FIELD_NAME = "//input[@id ='%s']";

    public static final String GENDER_OPTION = "//input[@value='%s']";
    public static final String SELECTED_DAY_DROPDOWN = "//select[@name = '%s']";

    public static final String SUMMARY_VALIDATION_ERROR = "//div[@class ='message-error validation-summary-errors']//li";

    public static final String MESSAGE_VERIFY_SUCCESS = "//div[@class = 'result'][contains(text(),'Your registration completed')]";
}
