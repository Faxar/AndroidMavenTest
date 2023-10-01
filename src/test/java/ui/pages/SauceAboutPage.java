package ui.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceAboutPage extends BasePage{

    @FindBy(xpath = "//img[@alt='Sauce Labs Logo Animation Still']")
    private WebElement aboutPageImgElement;

    public SauceAboutPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public boolean isShown() {
        return aboutPageImgElement.isDisplayed();
    }
}
