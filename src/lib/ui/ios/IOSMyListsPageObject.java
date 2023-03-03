package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject {

    static {
        ARTICLE_BY_TITLE_TMP = "xpath://XCUIElementTypeStaticText[@name='%s']/..";
        CLOSE_SYNC_YOUR_SAVED_ARTICLES_WINDOW = "xpath://XCUIElementTypeButton[@name='Close']";
        SWIPE_ACTION_DELETE_BUTTON = "xpath://XCUIElementTypeButton[@name='swipe action delete']";
    }

    public IOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
