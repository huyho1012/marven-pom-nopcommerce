package NopCommerce.Interface.User.MyAccount;


public class UserMyAccountCustomerInfoTabUI {
    public static final String TITLE_PAGE = "//div[@class ='page-title']/h1[contains(text(),'My account - Customer info')]";
    public static final String VALIDATE_ERROR_FIELD = "//span[@id='%s-error']";
    public static final String SAVE_BUTTON = "//input[@id ='save-info-button']";
    public static final String FIELD_NAME = "//input[@id ='%s']";
    public static final String GENDER_OPTION = "//input[@value='%s']";
    public static final String SELECTED_DAY_DROPDOWN = "//select[@name = '%s']";

    public static final String ADDRESSES_LINK = "//li[contains(@class,'customer-addresses')]/a";
    public static final String CHANGE_PASSWORD_LINK = "//li[contains(@class,'change-password')]/a";

}
