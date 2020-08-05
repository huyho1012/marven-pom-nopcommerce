package interfaces.wordPress.Admin;

public class LoginPageUI {
    public static final String USER_NAME_TEXTBOX = "//input[@id='usernameOrEmail']";
    public static final String CONTINUE_BUTTON = "//button[text()='Continue']";
    public static final String VALIDATE_ERR_MESSAGE_USERNAME = "//input[@id ='usernameOrEmail']/following::div[@class = 'form-input-validation is-error']";
    public static final String PASSWORD_TEXTBOX = "//input[@id='password']";
    public static final String VALIDATE_ERR_MESSAGE_PASSWORD ="//input[@id ='password']/following::div[@class = 'form-input-validation is-error']";
    public static final String LOGIN_BUTTON = "//button[text()='Log In']";
    public static final String CONTINUE_AGAIN_BUTTON = "//a[@class ='button is-primary']";
}
