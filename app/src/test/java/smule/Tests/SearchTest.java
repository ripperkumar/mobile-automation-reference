package smule.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import smule.Base.BaseTest;
import smule.pageObjects.LoginPage;
import smule.pageObjects.SearchPage;
import smule.pageObjects.SongPage;

public class SearchTest extends BaseTest {
    LoginPage loginPage;
    SongPage songBookPage;
    SearchPage searchPage;

    @Test(groups = {"RunAll","Sanity"})
    public void TestGoToSearchPage() throws InterruptedException {
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        searchPage = songBookPage.navigateToSearchPage();
        String text = searchPage.getTextFromSearchPage();
        Assert.assertEquals(text, "Trending", "Text from Search Page is not matching!!");
    }

    @Test(groups = {"regression","RunAll","Sanity"})
    public void testSearchSongs() throws InterruptedException {
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        searchPage = songBookPage.navigateToSearchPage();
        boolean result = searchPage.searchSong("Heeriye");
        Assert.assertTrue(result, "Songs list is not displayed!!");
    }
}
