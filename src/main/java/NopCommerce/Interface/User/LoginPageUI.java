package NopCommerce.Interface.User;

public class LoginPageUI {
    public static final String PASSWORD_TEXTBOX = "//input[@name = 'Password']";
    public static final String EMAIL_TEXTBOX = "//input[@name = 'Email']";
    public static final String ERR_VALIDATE_EMAIL = "//span[@id= 'Email-error']";
    public static final String LOGIN_BUTTON = "//input[contains(@class, 'login-button')]";
    public static final String LOGIN_ERROR_MESSAGE = "//div[@class ='message-error validation-summary-errors']";
}
