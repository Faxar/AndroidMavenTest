package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import ui.pages.*;
import ui.utils.TestListener;

@Feature("UI web page tests")
@ExtendWith(TestListener.class)
public class WebTest extends AndroidBaseTest {

    @BeforeEach
    public void setUp() {
        driver = initDriver();
    }

    /**
     * Test to check goRest web page navigation
     *
     * @result Test should verify that we are able to navigate
     * to correct page
     */
    @Test
    @Description("GoRest navigation positive test")
    public void helpTabTest() {
        driver.get(goRest);
        GoRestPage goRestPage = new GoRestPage(driver);
        makeScreenshot();
        goRestPage.popUpOkButton.click();
        GoRestQAPage goRestQAPage = goRestPage.openQAPage();
        Assertions.assertThat(goRestQAPage.qaHeader.getText()).as("Check header").isEqualTo("Questions and Answers");
    }

    /**
     * Test to check goRest web page navigation
     *
     * @result Test should fail on header validation
     */
    @Test
    @Description("GoRest navigation negative test")
    public void goRestNegativeTest() {
        driver.get(goRest);
        GoRestPage goRestPage = new GoRestPage(driver);
        makeScreenshot();
        goRestPage.popUpOkButton.click();
        Assertions.assertThat(goRestPage.pageHeader.getText()).as("Check page header").isEqualTo("Tres");
    }

    /**
     * Test to check Sauce Labs web page login
     *
     * @result Test should check if login is successful
     * and main page visible
     */
    @Test
    @Description("Sauce Labs login positive test")
    public void sauceLoginTest() {
        driver.get(sauceDemo);
        SauceLoginPage loginPage = new SauceLoginPage(driver);
        makeScreenshot();
        SauceMainPage sauceMainPage = loginPage.preformLogin();
        Assertions.assertThat(sauceMainPage.appLogo.getText()).as("Actual page logo").isEqualTo("Swag Labs");
    }

    /**
     * Test to check Sauce Labs about page
     *
     * @result Test should check if login is successful
     * and we are able to navigate to about page
     */
    @Test
    @Description("Sauce Labs about page positive test")
    public void sauceAboutPage() {
        driver.get(sauceDemo);
        SauceLoginPage loginPage = new SauceLoginPage(driver);
        makeScreenshot();
        SauceMainPage sauceMainPage = loginPage.preformLogin();
        SauceAboutPage sauceAboutPage = sauceMainPage.openAboutPage();
        Assertions.assertThat(sauceAboutPage.isShown()).isTrue();
    }

}
