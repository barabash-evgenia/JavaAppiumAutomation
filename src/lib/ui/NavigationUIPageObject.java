package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUIPageObject extends MainPageObject{

    protected static String MY_LISTS_LINK;

    public NavigationUIPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot find navigation button to My list",
                5
        );
    }

}
