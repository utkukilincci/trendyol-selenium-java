package Base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.Boolean.parseBoolean;
import static utils.LogUtils.logInfo;

public final class Config {
    public static final String BROWSER_NAME;
    public static final Boolean IS_HEADLESS;

    static {
        BROWSER_NAME = getBrowserName();
        IS_HEADLESS = getIsHeadless();
    }
    private static String getBrowserName() {
        String browser = System.getProperties().getProperty("browser");
        if(browser == null) {
            browser = loadProperties().getProperty("browser");
            logInfo("No browser option is set, please set -Dbrowser. Now default environment 'CHROME' will be set");
        }
        return browser;
    }

    private static Boolean getIsHeadless() {
        String isHeadless = System.getProperties().getProperty("headless");

        if (isHeadless == null) {
            isHeadless = loadProperties().getProperty("headless");
            logInfo("No headless option is set, please set -Dheadless. Now default environment 'false' will be set");
        }

        return parseBoolean(isHeadless);
    }

    private static Properties loadProperties() {
        String configFileName = "config.properties";
        InputStream in = ClassLoader.getSystemResourceAsStream(configFileName);
        Properties properties = new Properties();

        try {
            properties.load(in);
        } catch (IOException ioe) {
            throw new IllegalStateException("Exception on loading {" + configFileName + "} conf file from classpath", ioe);
        }
        return properties;
    }
}