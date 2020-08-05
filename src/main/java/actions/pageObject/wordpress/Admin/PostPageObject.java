package actions.pageObject.wordpress.Admin;

import actions.pageObject.wordpress.common.CommonPageObject;
import actions.pageObject.wordpress.common.PageGeneratorManager;
import interfaces.wordPress.Admin.PostPageUI;
import org.openqa.selenium.WebDriver;

public class PostPageObject extends CommonPageObject {
    WebDriver driver;
    public PostPageObject(WebDriver mapDriver) {
        driver = mapDriver;
    }

    public PostEditorPageObject clickToPostDetailByTitleName(String titleName) {
        waitForElementsVisible(driver, PostPageUI.TITLE_LINK,titleName);
        clickToElement(driver,PostPageUI.TITLE_LINK,titleName);
        return PageGeneratorManager.getPostDetailAdminPage(driver);
    }

    public PostEditorPageObject clickAddNewButton() {
        waitForElementClickable(driver, PostPageUI.ADD_NEW_POST_BUTTON);
        clickToElement(driver, PostPageUI.ADD_NEW_POST_BUTTON);
        return PageGeneratorManager.getPostDetailAdminPage(driver);
    }

    public void inputToSearchTextBox(String titlePost) {
        waitForElementsVisible(driver,PostPageUI.SEARcH_POST_FIELD);
        sendKeyToElement(driver,PostPageUI.SEARcH_POST_FIELD, titlePost);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, PostPageUI.SEARCH_BUTTON);
        clickToElement(driver, PostPageUI.SEARCH_BUTTON);
    }


}
