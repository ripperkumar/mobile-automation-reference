package smule.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import smule.utils.Utils;

public class SearchPage extends Utils {
    AndroidDriver driver;
    private ITesseract tess;


    public SearchPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.tess = new Tesseract();
        tess.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());

    }
    @AndroidFindBy(id = "com.smule.singandroid:id/trending_header_title")
    private WebElement trendingHeaderTitle;

    @AndroidFindBy(id = "com.smule.singandroid:id/search_edit_text")
    private WebElement searchBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='heeriye']")
    private WebElement searchResult;

    @AndroidFindBy(id = "com.smule.singandroid:id/search_showall_listview")
    private WebElement searchResultScreen;

    @AndroidFindBy(xpath = "com.smule.singandroid:id/search_mix_result_listview")
    private WebElement seeMixResultListView;



    public String getTextFromSearchPage() {
        return trendingHeaderTitle.getText();
    }

    public boolean searchSong(String songName) {
        searchBox.sendKeys(songName);
        searchResult.click();
        return seeMixResultListView.isDisplayed();
    }
}
