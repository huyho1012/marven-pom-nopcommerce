package interfaces.liveGuru;

public class LoginPageUI {

    public static final String USER_NAME_TEXTBOX = "//input[@id = 'email']";
    public static final String PASSWORD_TEXTBOX = "//input[@id = 'pass']";
    public static final String LOGIN_BUTTON = "//button[@id ='send2']";
    public static final String ERROR_MESSAGE_USER_NAME = "//input[@id = 'email']/following::div";
    public static final String ERROR_MESSAGE_PASSWORD ="//input[@id = 'pass']/following::div";
    public static final String LINK_FORGOT = "//a[text()='Forgot Your Password?']";
    public static final String CREATE_MY_ACCOUNT_BUTTON = "//span[text()='Create an Account']";
}
