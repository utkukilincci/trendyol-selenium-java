package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
    private static final Logger logger = LoggerFactory.getLogger("Log");
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void logInfo(final String message) {
        stringBuilder.append(message);
        logger.info(message);
    }

    public static void logError(final String message) {
        stringBuilder.append(message);
        logger.error(message);
    }
}
