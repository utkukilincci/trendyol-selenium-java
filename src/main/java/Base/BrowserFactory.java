package Base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Collections;

import static Base.Config.IS_HEADLESS;

public class BrowserFactory {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        if(IS_HEADLESS) {
            options.addArguments("--headless");
        }

        return options;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-popup-blocking");

        if(IS_HEADLESS) {
            options.addArguments("--headless");
        }

        return options;
    }
}