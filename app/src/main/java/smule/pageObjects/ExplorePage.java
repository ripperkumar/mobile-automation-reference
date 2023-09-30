package smule.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.utils.Utils;

public class ExplorePage extends Utils {
    AndroidDriver driver;

    public ExplorePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Moments']")
    private WebElement textFromExplorePage;

    public String getTextFromExplorePage() {
        return textFromExplorePage.getText();
    }
}
