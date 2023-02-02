package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.waitForTitleElement();
        String articleTitle = articlePageObject.getArticleTitle();
        String nameOfFolder = "Learning programming";
        articlePageObject.addArticleToNewList(nameOfFolder);
        articlePageObject.closeArticle();
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickMyLists();
        MyListsPageObject myListsPageObject = new MyListsPageObject(driver);
        myListsPageObject.openFolderByName(nameOfFolder);
        myListsPageObject.swipeByArticleToDelete(articleTitle);
    }

    @Test
    public void testSaveTwoArticlesToMyListAndDeleteOneFromMyList() {
        String searchLine = "Java";
        String nameOfFolder = "Learning programming";
        String firstArticleTitle = "High-level programming language";
        String secondArticleTitle = "Object-oriented programming language";
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        NavigationUI navigationUI = new NavigationUI(driver);
        MyListsPageObject myListsPageObject = new MyListsPageObject(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.clickByArticleWithSubstring(firstArticleTitle);
        articlePageObject.addArticleToNewList(nameOfFolder);
        articlePageObject.closeArticle();

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.clickByArticleWithSubstring(secondArticleTitle);
        articlePageObject.addArticleToExistingList(nameOfFolder);
        articlePageObject.closeArticle();

        navigationUI.clickMyLists();
        myListsPageObject.openFolderByName(nameOfFolder);
        myListsPageObject.waitForArticleToAppearByTitle(firstArticleTitle.toLowerCase());
        myListsPageObject.waitForArticleToAppearByTitle(secondArticleTitle.toLowerCase());
        myListsPageObject.swipeByArticleToDelete(firstArticleTitle.toLowerCase());
        myListsPageObject.waitForArticleToDisappearByTitle(firstArticleTitle.toLowerCase());
        myListsPageObject.waitForArticleToAppearByTitle(secondArticleTitle.toLowerCase());
    }
}
