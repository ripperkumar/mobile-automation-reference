package smule.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import smule.Base.BaseTest;
import smule.pageObjects.FeedPage;
import smule.pageObjects.LoginPage;
import smule.pageObjects.ProfilePage;
import smule.pageObjects.SongPage;
import smule.utils.Utils;

public class ProfileTest extends BaseTest {
    LoginPage loginPage;
    SongPage songBookPage;
    ProfilePage profilePage;
    FeedPage feedPage;

    @Test
    public void shouldGoToProfilePage() throws InterruptedException {
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        profilePage = songBookPage.navigateToProfilePage();
        String userName = profilePage.getUserNameFromProfilePage();
        Assert.assertEquals(userName, "RoshanKumar2807", "Username is not matching!!");
    }

    @Test
    public void shouldUpdateProfile() throws InterruptedException {
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        profilePage = songBookPage.navigateToProfilePage();
        String bio = Utils.generateBio();
        String result = profilePage.updateProfilePage(bio);
        Assert.assertEquals(result, bio, "Profile not updated!!");
    }

    @Test
    public void shouldBookMarkTheSong() throws InterruptedException {
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        songBookPage.bookmarkTheSong();
        profilePage = songBookPage.navigateToProfilePage();
        boolean result = profilePage.navigateToAboutPage();
        Assert.assertTrue(result, "Song is not bookmarked!!");
    }

    @Test
    void shouldAddSongToPlaylist() throws InterruptedException {
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        feedPage = songBookPage.navigateToFeedPage();
        feedPage.addSongToPlaylist();
        profilePage = songBookPage.navigateToProfilePage();
        String resultMessage = profilePage.navigateToPlaylist();
        Assert.assertNotEquals(resultMessage, "0 recordings", "Songs not added to Playlist!!");
    }

    @Test
    void shouldGoToInvitePage() throws InterruptedException {
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        profilePage = songBookPage.navigateToProfilePage();
        String result = profilePage.navigateToInvites();
        Assert.assertEquals(result, "Invite your friends to join a collab!", "text is not matching from Invite Page!!");
    }
}
