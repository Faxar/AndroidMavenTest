package ui.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.util.HashMap;

public class AppiumServerManager {
    static AppiumDriverLocalService service;
    public static void startServer() {
        String userHomeDir = System.getProperty("user.home");

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingAnyFreePort();
        builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
        builder.withAppiumJS(new File(userHomeDir + "\\AppData\\Roaming\\npm\\node_modules\\appium"));
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "usr/local/bin:" + System.getenv("PATH"));
        builder.withEnvironment(environment);
        try (AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder)) {
            service.start();
        }
    }

    public static void stopServer() {
        service.stop();
    }
}
