package log4jAppender;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jAppender {

    private static Logger logger = LogManager.getLogger(Log4jAppender.class);

    public static void main(String[] args) {

        logger.info("Log my all test");
        logger.error("Why my test is failing");
        logger.debug("Thanks for helping to debug this");
    }
}
