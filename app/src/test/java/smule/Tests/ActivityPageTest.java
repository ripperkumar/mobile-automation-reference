package smule.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import smule.Base.BaseTest;
import smule.pageObjects.ActivityPage;
import smule.pageObjects.LoginPage;
import smule.pageObjects.SongPage;

public class ActivityPageTest extends BaseTest {
    LoginPage loginPage;
    SongPage songBookPage;
    ActivityPage activityPage;
    @Test(groups = {"RunAll","Sanity"})
    public void testGoToInvitePage() throws InterruptedException{
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        activityPage = songBookPage.navigateToActivityPage();
        boolean result = activityPage.navigateToInvitePage();
        Assert.assertTrue(result, "Join button in InvitePage is not enabled!!");
    }

    @Test(groups = {"RunAll","Sanity"})
    public void testGoToNewsPage() throws InterruptedException{
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        activityPage = songBookPage.navigateToActivityPage();
        String text = activityPage.navigateToNewsPage();
        Assert.assertEquals(text, "No news from Smule yet", "Text from news page is not matching.");
    }

    @Test(groups = {"RunAll","Sanity"})
    public void testGoToNotification() throws InterruptedException{
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        activityPage = songBookPage.navigateToActivityPage();
        boolean result = activityPage.navigateToNotificationPage();
        Assert.assertTrue(result, "list of notification is not displayed!!");
    }
}
