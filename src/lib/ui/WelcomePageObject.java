package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject{

    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String ELEMENT_TYPE_STATIC_TEXT = "//XCUIElementTypeStaticText[@name='%s']";

    public void waitForLearnMoreLink() {
        this.waitForElementPresent(
//                By.xpath(String.format(ELEMENT_TYPE_STATIC_TEXT, "Learn more about Wikipedia")),
                By.xpath("//XCUIElementTypeStaticText[@name='Learn more about Wikipedia']"),
                "Cannot find 'Learn more about Wikipedia' link",
                10
        );
    }

    public void waitForNewWayToExploreText() {
        this.waitForElementPresent(
//                By.xpath(String.format(ELEMENT_TYPE_STATIC_TEXT, "New ways to explore")),
                By.xpath("//XCUIElementTypeStaticText[@name='New ways to explore']"),

                "Cannot find 'New ways to explore' text",
                10
        );
    }

    public void waitForAddOrEditPreferredLanguagesLink() {
        this.waitForElementPresent(
                By.xpath(String.format(ELEMENT_TYPE_STATIC_TEXT, "Add or edit preferred languages")),
                "Cannot find 'Add or edit preferred languages' link",
                10
        );
    }

    public void waitForLearnMoreAboutDataCollectedLink() {
        this.waitForElementPresent(
                By.xpath(String.format(ELEMENT_TYPE_STATIC_TEXT, "Learn more about data collected")),
                "Cannot find 'Learn more about data collected' link",
                10
        );
    }

    public void clickNextButton() {
        this.waitForElementAndClick(
//                By.xpath(String.format(ELEMENT_TYPE_STATIC_TEXT, "Next")),
                By.xpath("//XCUIElementTypeStaticText[@name='Next']"),
                "Cannot find and click 'Next' button",
                10
        );
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(
                By.xpath(String.format(ELEMENT_TYPE_STATIC_TEXT, "Get started")),
                "Cannot find and click 'Get started' button",
                10
        );
    }

}
