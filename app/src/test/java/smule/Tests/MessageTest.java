package smule.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import smule.Base.BaseTest;
import smule.pageObjects.LoginPage;
import smule.pageObjects.MessagePage;
import smule.pageObjects.SongPage;

public class MessageTest extends BaseTest {

    LoginPage loginPage;
    SongPage songBookPage;
    MessagePage messagePage;

    @Test
    public void shouldSendMessage() throws InterruptedException{
        String userName = "kbaganna";
        String message = "Hii";
        loginPage = new LoginPage(driver);
        songBookPage = loginPage.goToSongBookPage();
        messagePage = songBookPage.navigateToMessagePage();
        String result = messagePage.sendMessage(userName, message);
        Assert.assertEquals(result, "Hii", "Message not sent!!");
    }
}
