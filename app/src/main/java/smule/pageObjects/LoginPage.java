package smule.pageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.utils.Utils;


public class LoginPage extends Utils {
    AndroidDriver driver;
    public LoginPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='English' and @index='0']")
    private WebElement languageRadioButton;
    @AndroidFindBy(id = "com.smule.singandroid:id/yesButton")
    private WebElement okButton;

    @AndroidFindBy(id = "com.smule.singandroid:id/register_text")
    private WebElement header;

    @AndroidFindBy(id = "com.smule.singandroid:id/google_button_view")
    private WebElement signInWithGoogleButton;

    @AndroidFindBy(id = "com.google.android.gms:id/og_apd_internal_image_view")
    private WebElement googleDp;

    @AndroidFindBy(id = "com.smule.singandroid:id/noButton")
    private WebElement noButton;

    public void selectLanguage() throws InterruptedException {
        scrollToText("Español");
        languageRadioButton.click();
        okButton.click();
    }

    public String getHeaderText() {
        return header.getAttribute("text").toString();
    }
    public SongPage goToSongBookPage() throws InterruptedException {
        selectLanguage();
        signInWithGoogleButton.click();
        googleDp.click();
        noButton.click();
        return new SongPage(driver);
    }

}
