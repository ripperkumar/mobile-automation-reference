package smule.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.utils.Utils;

public class FeedPage extends Utils {
    AndroidDriver driver;

    public FeedPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Recommended for you']")
    private WebElement textFromFeedPage;

    @AndroidFindBy(id = "com.smule.singandroid:id/album_art_play_button_overlay")
    private WebElement videoPlayButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/action_button")
    private WebElement actionButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement permissionDenyButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.smule.singandroid:id/mMoreIcon']")
    private WebElement moreButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add to Playlist']")
    private WebElement addToPlaylistButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/txt_playlist_title")
    private WebElement playlistButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_profile")
    private WebElement profileButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/alert_btn_positive")
    private WebElement alertButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/img_close")
    private WebElement closeButton;

    public String getTextFromFeedPage() {
        return textFromFeedPage.getText();
    }

    public boolean playVideoFromFeedPage() {
        videoPlayButton.click();
        permissionDenyButton.click();
        return actionButton.isEnabled();
    }

    public void addSongToPlaylist() {
        moreButton.click();
        addToPlaylistButton.click();
        playlistButton.click();
        alertButton.click();
        closeButton.click();
        profileButton.click();
    }
}
