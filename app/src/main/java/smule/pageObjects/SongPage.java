package smule.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.utils.Utils;

public class SongPage extends Utils {
    AndroidDriver driver;
    public SongPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }



    @AndroidFindBy(id = "com.smule.singandroid:id/pre_search_title_text_view")
    private WebElement searchBox;

    @AndroidFindBy(id = "com.smule.singandroid:id/messageIcon")
    private WebElement messageButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_profile")
    private WebElement profileButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_activity")
    private WebElement activityButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_explore")
    private WebElement exploreButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_feed")
    private WebElement feedButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/menu_item_songbook")
    private WebElement songBookButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.smule.singandroid:id/root']")
    private WebElement songs;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bookmark Song']")
    private WebElement bookMarkButton;

    public boolean isSearchBarVisible(){
        return searchBox.isDisplayed();
    }

    public MessagePage navigateToMessagePage() {
        Utils.tap();
        messageButton.click();
        return new MessagePage(driver);
    }

    public FeedPage navigateToFeedPage() {
        Utils.tap();
        feedButton.click();
        return new FeedPage(driver);
    }

    public ExplorePage navigateToExplorePage() {
        Utils.tap();
        exploreButton.click();
        return new ExplorePage(driver);
    }

    public ActivityPage navigateToActivityPage() {
        Utils.tap();
        activityButton.click();
        return new ActivityPage(driver);
    }

    public ProfilePage navigateToProfilePage() {
        Utils.tap();
        profileButton.click();
        return new ProfilePage(driver);
    }

    public SearchPage navigateToSearchPage() {
        Utils.tap();
        searchBox.click();
        return new SearchPage(driver);
    }

    public void bookmarkTheSong() {
        Utils.longPress(songs);
        bookMarkButton.click();
    }
}
