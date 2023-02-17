package tests.iOS;

import lib.iOSTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedClass extends iOSTestCase {

    @Test
    public void testPassThroughWelcome() {
        WelcomePageObject welcomePage = new WelcomePageObject(driver);
        welcomePage.waitForLearnMoreLink();
        welcomePage.clickNextButton();
        welcomePage.waitForNewWayToExploreText();
        welcomePage.clickNextButton();
        welcomePage.waitForAddOrEditPreferredLanguagesLink();
        welcomePage.clickNextButton();
        welcomePage.waitForLearnMoreAboutDataCollectedLink();
        welcomePage.clickGetStartedButton();
    }
}
