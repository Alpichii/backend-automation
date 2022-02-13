package stepDef;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DBUtil;

public class DBStepDef {

    private final Logger logger = LogManager.getLogger(DBStepDef.class);
    @Given("User is able to connect to database")
    public void user_is_able_to_connect_to_database() {
        DBUtil.createDBConnection();
        System.out.println("I am able to connect to db");
        logger.info("I can connect to my database");
        logger.info("Can connect to db");
    }
}
