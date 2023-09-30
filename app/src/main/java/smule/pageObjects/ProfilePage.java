package smule.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.utils.Utils;

public class ProfilePage extends Utils {
    AndroidDriver driver;

    public ProfilePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    FeedPage feedPage = new FeedPage(driver);

    @AndroidFindBy(id = "com.smule.singandroid:id/txt_username")
    private WebElement userName;

    @AndroidFindBy(id = "com.smule.singandroid:id/btn_edit_profile")
    private WebElement editProfileButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/txt_profile_blurb")
    private WebElement profileBio;

    @AndroidFindBy(id = "com.smule.singandroid:id/edit_bio")
    private WebElement bioTextBox;

    @AndroidFindBy(id = "com.smule.singandroid:id/btn_save")
    private WebElement saveButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
    private WebElement aboutButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/btn_view_all")
    private WebElement viewAllButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Playlists']")
    private WebElement playlistButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/txt_playlist_subtitle")
    private WebElement numberOfSongAddedToPlaylist;

    @AndroidFindBy(id = "com.smule.singandroid:id/img_arrow_right")
    private WebElement goToFavoritePlaylistButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/btn_recording_edit")
    private WebElement editButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/icon")
    private WebElement deleteButtonIcon;

    @AndroidFindBy(id = "com.smule.singandroid:id/btn_back")
    private WebElement backButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/txt_empty_invites_info")
    private WebElement inviteInfoText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Invites']")
    private WebElement inviteButton;


    public String getUserNameFromProfilePage() {
        return userName.getText();
    }

    public String updateProfilePage(String bio) {
        editProfileButton.click();
        Utils.scrollToView("Show Mentions");
        bioTextBox.sendKeys(bio);
        saveButton.click();
        return profileBio.getText();
    }

    public boolean navigateToAboutPage() {
        aboutButton.click();
        return viewAllButton.isDisplayed();
    }

    public String navigateToPlaylist() {
        playlistButton.click();
        return numberOfSongAddedToPlaylist.getText();
    }

    public String navigateToInvites() {
        inviteButton.click();
        return inviteInfoText.getText();
    }
}
