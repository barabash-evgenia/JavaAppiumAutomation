package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUIPageObject;

public class IOSNavigationPageObject extends NavigationUIPageObject {

    static {
        MY_LISTS_LINK = "xpath://XCUIElementTypeButton[@name='Saved']";
    }

    public IOSNavigationPageObject(AppiumDriver driver) {
        super(driver);
    }
}
