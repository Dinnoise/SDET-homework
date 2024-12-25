import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestLogger {

    private static Logger logger = LoggerFactory.getLogger(TestLogger.class);

    @Test
    public void TestTrace() {
        logger.trace("Trace");
    }

    @Test
    public void testDebug(){
        logger.debug("Debugging");
    }

    @Test
    public void testInfo(){
        logger.debug("Hello");
    }

    @Test
    public void testWarn(){
        logger.debug("Warning!");
    }

    @Test
    public void testError(){
        logger.error("Error!");
    }
}
