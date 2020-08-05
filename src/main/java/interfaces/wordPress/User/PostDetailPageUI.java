package interfaces.wordPress.User;

public class PostDetailPageUI {
    public static final String CATEGORY_POST = "//p[@class ='post-categories']/a[contains(text(),'%s')]";
    public static final String TITLE_POST = "//h1[@class ='post-title'][contains(text(),'%s')]";

    public static final String CREATED_DATE_POSt = "//span[@class = 'post-meta-date']/a[contains(text(),'%s')]";
    public static final String AUTHOR_POSt = "//span[@class = 'post-meta-author']/a[contains(text(),'%s')]";
    public static final String IMAGE_POST = "//img[contains(@src,'%s')]";
    public static final String POST_CONTENT = "//div[@class ='post-content']/p[contains(text(),'%s')]";
    public static final String TAG_POSt = "//div[@class = 'post-tags']/a[contains(text(),'%s')]";
}
