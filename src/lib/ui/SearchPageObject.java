package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]",
                                SEARCH_INPUT = "xpath://*[contains(@text,'Search…')]",
                                SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn",
                                SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='%s']",
                                SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
                                SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='%s']/following-sibling::*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='%s']",
                                SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']",
                                ANY_SEARCH_LIST_RESULT = "id:org.wikipedia:id/page_list_item_container";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click init element", 5);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    public void clickCancelButton() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }


    public void typeSearchLine(String searchLine) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, searchLine,"Cannot find and type into input", 5);
    }

    public void waitForSearchResult(String substring) {
        String searchResultXpath = String.format(SEARCH_RESULT_BY_SUBSTRING_TPL, substring);
        this.waitForElementPresent(searchResultXpath, "Cannot find search result with substring " + substring);
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        this.waitForElementPresent(String.format(SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL, title, description),
                "Cannot find search result with title '" + title + "' and description '" + description + "'");
    }

    public void clickByArticleWithSubstring(String substring) {
        String searchResultXpath = String.format(SEARCH_RESULT_BY_SUBSTRING_TPL, substring);
        this.waitForElementAndClick(searchResultXpath, "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles(String searchLine) {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request " + searchLine,
                15
        );
        return this.getAmountOfElements(
                SEARCH_RESULT_ELEMENT
        );
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 15);
    }

    public void assertThereIsNoResultOfSearch() {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
    }

    public void waitForAnySearchResult() {
        this.waitForElementPresent(ANY_SEARCH_LIST_RESULT, "Cannot find any search result", 5);
    }

    public void waitForAnySearchResultToDisappear() {
        this.waitForElementNotPresent(ANY_SEARCH_LIST_RESULT, "Search result is still present", 5);
    }

}
