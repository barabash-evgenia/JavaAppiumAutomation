package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://XCUIElementTypeButton[@name='Save for later']";
        CLOSE_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name='Back']";
    }

    public IOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
