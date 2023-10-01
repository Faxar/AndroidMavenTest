package ui.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    public AndroidDriver driver;
    public WebDriverWait wait;

    public String goRest;
    public String sauceDemo;

    public void setDriver() throws MalformedURLException {
        DesiredCapabilities androidCaps = new DesiredCapabilities();
        androidCaps.setCapability("appium:deviceName", "sdk-gphone64_x86_64");
        androidCaps.setCapability("appium:automationName", "UIAutomator2");
        androidCaps.setCapability("appium:platformName", "Android");
        androidCaps.setCapability("appium:browserName", "chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), androidCaps);

        goRest = "https://gorest.co.in/";
        sauceDemo = "https://www.saucedemo.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
