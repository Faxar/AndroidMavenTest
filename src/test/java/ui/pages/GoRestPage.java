package ui.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.stream.Stream;

public class GoRestPage extends BasePage {
    @FindBy(className = "fc-button-label")
    public WebElement popUpOkButton;
    @FindBy(className = "navbar-toggler-icon")
    private WebElement burgerMenu;
    @FindBy(xpath = "//a[@href='/qa']")
    private WebElement dropDownHelpElement;
    @FindBy(xpath = "//h1[@class='text-center']")
    public WebElement pageHeader;

    @Step("Navigate to QA page")
    public GoRestQAPage openQAPage() {
        burgerMenu.click();
        dropDownHelpElement.click();
        return new GoRestQAPage(driver);
    }

    public GoRestPage(AndroidDriver driver) {super(driver);}

    @Override
    public boolean isShown() { return burgerMenu.isDisplayed();
    }
}
