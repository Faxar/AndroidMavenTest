package ui.tests;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Logger;

public class AndroidBaseTest {
    public static final String APPIUM_URL = "http://127.0.0.1:4723/";
    public static final String ANDROID_PLATFORM_NAME = "Android";
    public static AndroidDriver driver;
    public static String goRest;
    public static String sauceDemo;

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    Logger log = Logger.getLogger(AndroidBaseTest.class.getName());

    static AndroidDriver initDriver() {
        try {
            driver = new AndroidDriver(new URL(APPIUM_URL), getLocalCapabilities());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium driver could not be initialized." + e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        goRest = "https://gorest.co.in/";
        sauceDemo = "https://www.saucedemo.com/";
        return driver;
    }

    private static DesiredCapabilities getLocalCapabilities() {
        DesiredCapabilities androidCaps = new DesiredCapabilities();
        androidCaps.setCapability("appium:deviceName", "sdk-gphone64_x86_64");
        androidCaps.setCapability("appium:automationName", "UIAutomator2");
        androidCaps.setCapability("appium:platformName", "Android");
        androidCaps.setCapability("appium:browserName", "chrome");
        return androidCaps;
    }
}
