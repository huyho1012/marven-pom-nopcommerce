package interfaces.wordPress.Common;

public class CommonPageUI {
    public static final String UploadButton = "//input[@type ='file']";
    public static final String LIST_FILE_UPLOADED = "//div[@class ='thumbnail']//img";
    public static final String USER_WORD_PRESS_LINK = "https://automationfc.wordpress.com";
    public static final String ADMIN_WORD_PRESS_LINK = "https://automationfc.wordpress.com/wp-admin/";
    public static final String DYNAMIC_MESSAGE = "//div[@id= 'message']/p[contains(text(), '%s')]";
    public static final String DYNAMIC_DATA_ON_COLUMN = "//td[contains(@class, '%s')]//a[text() ='%s']";
}
