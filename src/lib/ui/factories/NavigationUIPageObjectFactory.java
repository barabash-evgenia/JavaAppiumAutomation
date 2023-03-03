package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.NavigationUIPageObject;
import lib.ui.android.AndroidNavigationPageObject;
import lib.ui.ios.IOSNavigationPageObject;

public class NavigationUIPageObjectFactory {

    public static NavigationUIPageObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationPageObject(driver);
        } else {
            return new IOSNavigationPageObject(driver);
        }
    }
}
