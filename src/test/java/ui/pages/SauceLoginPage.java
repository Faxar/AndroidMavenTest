package ui.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.stream.Stream;

public class SauceLoginPage extends BasePage{

    private String pwd = "secret_sauce";
    private String user = "standard_user";

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public SauceLoginPage(AndroidDriver driver) {
        super(driver);
    }

    private void setUserName() {
        userNameField.sendKeys(user);
    }

    private void setPassword() {
        passwordField.sendKeys(pwd);
    }

    @Step("Click login button")
    public SauceMainPage preformLogin() {
        setUserName();
        setPassword();
        loginButton.click();
        return new SauceMainPage(driver);
    }

    @Override
    public boolean isShown() {return Stream.of(userNameField, passwordField, loginButton).allMatch(WebElement::isDisplayed);
    }
}
