package smule.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import smule.Base.BaseTest;
import smule.pageObjects.ExplorePage;
import smule.pageObjects.LoginPage;
import smule.pageObjects.SongPage;

public class ExploreTest extends BaseTest {
    LoginPage loginPage;
    SongPage songBookPage;
    ExplorePage explorePage;

    @Test(groups = {"RunAll","Sanity"})
    public void testGotoExplorePage() throws InterruptedException {
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        explorePage = songBookPage.navigateToExplorePage();
        String text = explorePage.getTextFromExplorePage();
        Assert.assertEquals(text, "Moments", "Text from Explore page is not matching!!");
    }
}
