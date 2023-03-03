package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUIPageObject;

public class AndroidNavigationPageObject extends NavigationUIPageObject {

    static {
        MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }

    public AndroidNavigationPageObject(AppiumDriver driver) {
        super(driver);
    }
}
