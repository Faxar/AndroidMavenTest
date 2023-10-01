package ui.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.stream.Stream;

public class SauceMainPage extends BasePage{
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;
    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;
    @FindBy(className = "app_logo")
    public WebElement appLogo;

    @Step("Open sauce about page")
    public SauceAboutPage openAboutPage() {
        burgerMenu.click();
        aboutLink.click();
        return new SauceAboutPage(driver);
    }

    public SauceMainPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public boolean isShown() {
        return Stream.of(burgerMenu, appLogo).allMatch(WebElement::isDisplayed);
    }
}
