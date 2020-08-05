package interfaces.wordPress.User;

public class HomePageUI {
    public static final String CATEGORY_TITLE_DATE = "//a[contains(text(),'%s')]/parent::h2/preceding-sibling::p//a[contains(text(),'%s')]/parent::p/following-sibling::p[@class ='post-meta']/a[contains(text(),'%s')]";
    public static final String DYNAMIC_POST_AVATAR = "//a[@title='%s']/img[contains(@src,'%s')]";
    public static final String DYNAMIC_POST_TITLE= "//h2[@class='post-title']/a[contains(text(),'%s')]";

    public static final String SEARCH_ICON = "//a[@class ='search-toggle']";
    public static final String SEARCH_FIELD = "//input[@class ='search-field']";
    public static final String SEARCH_BUTTON = "//span[@class ='fa fw fa-search']";
}
