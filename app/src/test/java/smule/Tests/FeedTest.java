package smule.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import smule.Base.BaseTest;
import smule.pageObjects.FeedPage;
import smule.pageObjects.LoginPage;
import smule.pageObjects.SongPage;

public class FeedTest extends BaseTest {

    LoginPage loginPage;
    SongPage songBookPage;
    FeedPage feedPage;

    @Test(groups = {"regression","RunAll","Sanity"})
    public void testPlayVideo() throws InterruptedException {
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        feedPage = songBookPage.navigateToFeedPage();
        boolean result = feedPage.playVideoFromFeedPage();
        Assert.assertTrue(result, "Video is not playing!!");
    }
}
