import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
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
    public void testSearchAndCancelSearch() {
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
                By.id("org.wikipedia:id/page_list_item_container"),
                "Cannot find any search result",
                5
        );

        if (mainPageObject.getListOfElements(By.id("org.wikipedia:id/page_list_item_container")).size() <= 1) {
            Assert.fail("Search result contains less than two items");
        }

        mainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find 'X' to cancel search",
                5
        );

        mainPageObject.waitForElementNotPresent(
                By.id("org.wikipedia:id/page_list_item_container"),
                "Search result not empty",
                5
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

    @Test
    public void testSaveTwoArticlesToMyListAndDeleteOneFromMyList() {
        String searchLine = "Java";
        String folderName = "Learning programming";
        String firstArticleTitle = "High-level programming language";
        String secondArticleTitle = "Object-oriented programming language";

        mainPageObject.findArticlesBySearchLine(searchLine);
        mainPageObject.addAnArticleToNewList(firstArticleTitle, folderName);
        mainPageObject.findArticlesBySearchLine(searchLine);
        mainPageObject.addAnArticleToExistingList(secondArticleTitle, folderName);

        mainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to My list",
                5
        );
        mainPageObject.waitForElementPresent(
                By.xpath("//android.widget.TextView[@text='" + folderName + "']"),
                "Cannot find created folder",
                5
        );
        mainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='" + folderName + "']"),
                "Cannot find created folder",
                5
        );
        mainPageObject.waitForElementPresent(
                By.xpath("//*[@text='" + firstArticleTitle.toLowerCase() + "']"),
                "Cannot find an article with title '" + firstArticleTitle + "' in folder " + folderName,
                5
        );
        mainPageObject.waitForElementPresent(
                By.xpath("//*[@text='" + secondArticleTitle.toLowerCase() + "']"),
                "Cannot find an article with title '" + secondArticleTitle + "' in folder " + folderName,
                5
        );
        mainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='" + firstArticleTitle.toLowerCase()+ "']"),
                "Cannot find an article with title '" + firstArticleTitle + "' in folder " + folderName
        );
        mainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='" + firstArticleTitle.toLowerCase() + "']"),
                "The article with title '" + firstArticleTitle + "' is located in folder " + folderName,
                5
        );
        mainPageObject.waitForElementPresent(
                By.xpath("//*[@text='" + secondArticleTitle.toLowerCase() + "']"),
                "Cannot find an article with title '" + secondArticleTitle + "' in folder " + folderName,
                5
        );
    }

    @Test
    public void testAssertTitle() {
        String searchLine = "Java";
        String articleTitle = "Object-oriented programming language";
        mainPageObject.findArticlesBySearchLine(searchLine);
        mainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='" + articleTitle + "']"),
                "Cannot find '" + articleTitle + "' topic",
                15
        );
        mainPageObject.assertElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title"
        );
    }
}

