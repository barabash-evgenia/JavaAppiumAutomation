package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{

    private static final String
            FOLDER_BY_NAME_TPL = "//android.widget.TextView[@text='%s']",
            ARTICLE_BY_TITLE_TMP = "//*[@text='%s']";

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openFolderByName(String nameOfFolder) {
        String folderNameXpath = String.format(FOLDER_BY_NAME_TPL, nameOfFolder);
        this.waitForElementPresent(
                By.xpath(folderNameXpath),
                "Cannot find folder by name" + nameOfFolder,
                5
        );
        this.waitForElementAndClick(
                By.xpath(folderNameXpath),
                "Cannot find folder by name" + nameOfFolder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String articleTitle) {
        String articleTitleXpath = String.format(ARTICLE_BY_TITLE_TMP, articleTitle);
        this.waitForElementPresent(
                By.xpath(articleTitleXpath),
                "Cannot find saved article still by title " + articleTitle,
                15
        );
    }

    public void waitForArticleToDisappearByTitle(String articleTitle) {
        String articleTitleXpath = String.format(ARTICLE_BY_TITLE_TMP, articleTitle);
        this.waitForElementNotPresent(
                By.xpath(articleTitleXpath),
                "Saved article still present with title " + articleTitle,
                15
        );
    }
    public void swipeByArticleToDelete(String articleTitle) {
        this.waitForArticleToAppearByTitle(articleTitle);
        String articleTitleXpath = String.format(ARTICLE_BY_TITLE_TMP, articleTitle);
        this.swipeElementToLeft(
                By.xpath(articleTitleXpath),
                "Cannot find saved article"
        );
        this.waitForArticleToDisappearByTitle(articleTitle);
    }

}