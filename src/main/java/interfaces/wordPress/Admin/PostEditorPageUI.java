package interfaces.wordPress.Admin;

public class PostEditorPageUI {
    public static final String TITLE_POST_TEXT_BOX = "//input[@name= 'post_title']";
    public static final String FRAME = "//iframe[@id = 'content_ifr']";
    public static final String POST_CONTENT_TEXT_AREA = "//body[@id = 'tinymce']//p";
    public static final String CATEGORY_CHECK_BOX = "//label[contains(text(),'%s')]";
    public static final String TAG_TEXT_BOX = "//input[@id = 'new-tag-post_tag']";
    public static final String ADD_TAG_BUTTON = "//input[@class= 'button tagadd']";
    public static final String SET_FEATURE_IMAGE_LINK = "//a[@id = 'set-post-thumbnail']";
    public static final String UPLOAD_BUTTON = "//button[@id= 'menu-item-upload']";
    public static final String SET_FEATURE_IMAGE_BUTTON = "//button[text()= 'Set featured image']";
    public static final String FEATURE_IMAGE = "//a[@id= 'set-post-thumbnail']//img[contains(@src ,'%s')]";
    public static final String PUBLISH_BUTTON = "//input[@id = 'publish']";

    public static final String REMOVE_TAGGING_BUTTON = "//span[contains(text(),'%s')]/ancestor::button[@class='ntdelbutton']";


}


