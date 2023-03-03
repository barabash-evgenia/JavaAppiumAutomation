package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUIPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIPageObjectFactory;
import org.junit.Test;
import lib.ui.factories.SearchPageObjectFactory;

public class MyListsTests extends CoreTestCase {

    private static final String nameOfFolder = "Learning programming";

    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String articleTitle = articlePageObject.getArticleTitle();
        if (Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToNewList(nameOfFolder);
        } else {
            articlePageObject.addArticlesToMySaved();
        }
        articlePageObject.closeArticle();
        if (Platform.getInstance().isIOS()){
            searchPageObject.clickCancelButton();
        }
        NavigationUIPageObject navigationUI = NavigationUIPageObjectFactory.get(driver);
        navigationUI.clickMyLists();
        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()){
            myListsPageObject.openFolderByName(nameOfFolder);
        } else {
            myListsPageObject.closeSyncYourSavedArticlesWindow();
        }
        myListsPageObject.swipeByArticleToDelete(articleTitle);
    }

    @Test
    public void testSaveTwoArticlesToMyListAndDeleteOneFromMyList() {
        String searchLine = "Java";
        String nameOfFolder = "Learning programming";
        String firstArticleTitle = "High-level programming language";
        String secondArticleTitle = "Object-oriented programming language";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUIPageObject navigationUI = NavigationUIPageObjectFactory.get(driver);;
        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.clickByArticleWithSubstring(firstArticleTitle);
        if (Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToNewList(nameOfFolder);
        } else {
            articlePageObject.addArticlesToMySaved();
        }
        articlePageObject.closeArticle();
        if (Platform.getInstance().isAndroid()){
            searchPageObject.initSearchInput();
            searchPageObject.typeSearchLine(searchLine);
        }
        searchPageObject.clickByArticleWithSubstring(secondArticleTitle);
        if (Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToExistingList(nameOfFolder);
        } else {
            articlePageObject.addArticlesToMySaved();
        }
        articlePageObject.closeArticle();
        if (Platform.getInstance().isIOS()){
            searchPageObject.clickCancelButton();
        }
        navigationUI.clickMyLists();
        if (Platform.getInstance().isAndroid()){
            myListsPageObject.openFolderByName(nameOfFolder);
        } else {
            myListsPageObject.closeSyncYourSavedArticlesWindow();
        }
        if (Platform.getInstance().isAndroid()){
            myListsPageObject.waitForArticleToAppearByTitle(firstArticleTitle.toLowerCase());
            myListsPageObject.waitForArticleToAppearByTitle(secondArticleTitle.toLowerCase());
            myListsPageObject.swipeByArticleToDelete(firstArticleTitle.toLowerCase());
            myListsPageObject.waitForArticleToDisappearByTitle(firstArticleTitle.toLowerCase());
            myListsPageObject.waitForArticleToAppearByTitle(secondArticleTitle.toLowerCase());
        } else {
            myListsPageObject.waitForArticleToAppearByTitle(firstArticleTitle);
            myListsPageObject.waitForArticleToAppearByTitle(secondArticleTitle);
            myListsPageObject.swipeByArticleToDelete(firstArticleTitle);
            myListsPageObject.waitForArticleToDisappearByTitle(firstArticleTitle);
            myListsPageObject.waitForArticleToAppearByTitle(secondArticleTitle);
        }
    }
}
