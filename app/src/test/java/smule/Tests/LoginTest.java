package smule.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import smule.Base.BaseTest;
import smule.pageObjects.LoginPage;
import smule.pageObjects.SongPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    SongPage songBookPage;


    @Test
    public void testingLanguageSelection() throws InterruptedException {
        String actualLoginHeader ="Sing millions of songs and make friends through music";
        loginPage = new LoginPage(driver);
        loginPage.selectLanguage();
        String loginHeader = loginPage.getHeaderText();
        Assert.assertEquals(loginHeader,actualLoginHeader,"Login Header not matching");
    }

    @Test
    public void shouldGoToSongBookPage() throws InterruptedException {
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        Assert.assertTrue(songBookPage.isSearchBarVisible());
    }
}
