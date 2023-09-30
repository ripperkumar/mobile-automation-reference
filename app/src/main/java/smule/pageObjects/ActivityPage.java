package smule.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.utils.Utils;

public class ActivityPage extends Utils {
    AndroidDriver driver;

    public ActivityPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Invites']")
    private WebElement invitesButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications']")
    private WebElement notificationButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='News']")
    private WebElement newsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No news from Smule yet']")
    private WebElement messageFromNewsPage;

    @AndroidFindBy(id = "com.smule.singandroid:id/notifications_listview")
    private WebElement notificationsList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Join']")
    private WebElement joinButtonOfInvitePage;

    public boolean navigateToInvitePage() {
        Utils.tap();
        return joinButtonOfInvitePage.isEnabled();
    }

    public String navigateToNewsPage() {
        Utils.tap();
        newsButton.click();
        return messageFromNewsPage.getText();
    }

    public boolean navigateToNotificationPage() {
        Utils.tap();
        notificationButton.click();
        return notificationsList.isDisplayed();
    }
}
