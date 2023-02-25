package tests.iOS;

import lib.CoreTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedClass extends CoreTestCase {

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
