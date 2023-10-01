package ui.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoRestQAPage extends BasePage{
    @FindBy(xpath = "//h1[contains(text(), 'Questions and Answers')]")
    public WebElement qaHeader;

    public GoRestQAPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public boolean isShown() {
        return qaHeader.isDisplayed();
    }
}
