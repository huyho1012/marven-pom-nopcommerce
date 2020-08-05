package interfaces.bankGuru;

public class RegisterPageUI {
    public static final String BUTTON_SUBMIT = "//input[@name ='btnLogin']";
    public static final String EMAIL_ID_FIELD = "//input[@name ='emailid']";
    public static final String ERROR_MESSAGE_VALIDATE = "//input[@name ='emailid']/following-sibling::label";

    public static final String USER_ID_COLUMN_DATA = "//td[contains(text(),'User ID')]/following-sibling::td";
    public static final String PASSWORD_COLUMN_DATA = "//td[contains(text(),'Password')]/following-sibling::td";
}
