package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListsPageObject extends MainPageObject{

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TMP,
            CLOSE_SYNC_YOUR_SAVED_ARTICLES_WINDOW,
            SWIPE_ACTION_DELETE_BUTTON;

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openFolderByName(String nameOfFolder) {
        String folderNameXpath = String.format(FOLDER_BY_NAME_TPL, nameOfFolder);
        this.waitForElementPresent(
                folderNameXpath,
                "Cannot find folder by name" + nameOfFolder,
                5
        );
        this.waitForElementAndClick(
                folderNameXpath,
                "Cannot find folder by name" + nameOfFolder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String articleTitle) {
        String articleTitleXpath = String.format(ARTICLE_BY_TITLE_TMP, articleTitle);
        this.waitForElementPresent(
                articleTitleXpath,
                "Cannot find saved article still by title " + articleTitle,
                15
        );
    }

    public void waitForArticleToDisappearByTitle(String articleTitle) {
        String articleTitleXpath = String.format(ARTICLE_BY_TITLE_TMP, articleTitle);
        this.waitForElementNotPresent(
                articleTitleXpath,
                "Saved article still present with title " + articleTitle,
                15
        );
    }
    public void swipeByArticleToDelete(String articleTitle) {
        this.waitForArticleToAppearByTitle(articleTitle);
        String articleTitleXpath = String.format(ARTICLE_BY_TITLE_TMP, articleTitle);
        this.swipeElementToLeft(
                articleTitleXpath,
                "Cannot find saved article"
        );
        if (Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(articleTitleXpath, "Cannot find saved article");
            this.clickSwipeActionDeleteButton();
        }
        this.waitForArticleToDisappearByTitle(articleTitle);
    }

    public void closeSyncYourSavedArticlesWindow() {
        this.waitForElementAndClick(CLOSE_SYNC_YOUR_SAVED_ARTICLES_WINDOW,
                "Cannot find 'X' button to close 'Sync your saved articles?' window",
                5);
    }

    public void clickSwipeActionDeleteButton() {
        this.waitForElementAndClick(SWIPE_ACTION_DELETE_BUTTON,
                "Cannot find 'swipe action delete' button",
                5);
    }

}
