package ui.utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Optional;

import static ui.tests.AndroidBaseTest.driver;

public class TestListener implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment(
                "screenshot", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
        tearDown();
    }
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        tearDown();
    }
    @Override
    public void testSuccessful(ExtensionContext context) {
        tearDown();
    }
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        tearDown();
    }

    private void tearDown() {
        driver.close();
        driver.quit();
    }
}
