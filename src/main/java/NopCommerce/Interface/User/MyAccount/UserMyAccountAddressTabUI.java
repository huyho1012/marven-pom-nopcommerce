package NopCommerce.Interface.User.MyAccount;

public class UserMyAccountAddressTabUI {
    public static final String TITLE_ADDRESS_TAB ="//div[@class = 'page-title']/h1[text()='My account - Addresses']";
    public static final String TITLE_ADD_NEW_ADDRESS_TAB ="//div[@class = 'page-title']/h1[text()='My account - Add new address']";
    public static final String ADD_ADDRESS_BUTTON = "//input[contains(@class,'add-address-button')]";
    public static final String DYNAMIC_TEXT_BOX = "//input[@id = '%s']";
    public static final String COUNTRY_DROPDOWN = "//select[@id = 'Address_CountryId']";
    public static final String STATE_DROPDOWN = "//select[@id = 'Address_StateProvinceId']";
    public static final String LOADING_PROCESSING_BAR = "//span[@id = 'states-loading-progress']";
    public static final String SAVE_BUTTON = "//input[contains(@class, 'save-address-button')]";

    public static final String DATA_DISPLAY_FIELD = "//li[@class = '%s']";

}
