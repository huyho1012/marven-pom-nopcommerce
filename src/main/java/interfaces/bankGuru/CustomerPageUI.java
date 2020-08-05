package interfaces.bankGuru;

public class CustomerPageUI {

    public static final String DYNAMIC_TEXT_FIELD = "//input[@name = '%s']";
    public static final String DYNAMIC_TEXT_AREA = "//textarea[@name = '%s']";
    public static final String DYNAMIC_RADIO_BUTTON = "//input[@type= 'radio'][@name = '%s']";
    public static final String DYNAMIC_MENU = "//a[text()='%s']";
    public static final String DYNAMIC_BUTTON = "//input[@value= '%s']";
    public static final String DYNAMIC_TITLE_PAGE = "//marquee[@class ='heading3'][contains(text(),'%s')]";

    public static final String DATA_BY_DYNAMIC_COLUMN = "//td[contains(text(),'%s')]/following-sibling::td";
}
