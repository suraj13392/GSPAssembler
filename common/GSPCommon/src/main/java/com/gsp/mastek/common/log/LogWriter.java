package com.gsp.mastek.common.log;

import org.apache.log4j.Logger;
import org.springframework.boot.logging.LogLevel;

public class LogWriter {

	public static void write(Class clazz, LogLevel logLevel, String message) {
        Logger logger = Logger.getLogger(clazz);

        switch (logLevel) {
            case TRACE:
                logger.trace(message);
                break;
            case DEBUG:
                logger.debug(message);
                break;
            case INFO:
                logger.info(message);
                break;
            case WARN:
                logger.warn(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            case FATAL:
                logger.fatal(message);
                break;
            default:
                logger.warn("No suitable log level found");
                break;
        }
    }
}
