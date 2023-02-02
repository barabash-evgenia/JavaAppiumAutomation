import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstTest extends CoreTestCase {

    private MainPageObject mainPageObject;
    protected void setUp() throws Exception {
        super.setUp();

        mainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testCompareSearchFieldText() {
        mainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search 'Search Wikipedia' input",
                5
        );
        mainPageObject.assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search…",
                "Search field has an unexpected text"
        );
    }

    @Test
    public void testCheckASpecificWordInEachSearchResult() {
        mainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search 'Search Wikipedia' input",
                5
        );

        mainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find 'Search…' input",
                15
        );

        mainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Cannot find any search result",
                5
        );

        for (WebElement element: mainPageObject.getListOfElements(By.id("org.wikipedia:id/page_list_item_title"))) {
            mainPageObject.assertElementContainsText(
                    element,
                    "Java",
                    "Search result doesn't contain a word 'Java'");
        }
    }
}

