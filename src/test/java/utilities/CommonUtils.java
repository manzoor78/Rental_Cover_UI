package utilities;

import java.time.Duration;

public class CommonUtils {

    public static void waitImplicitlyInSeconds(long seconds) {
        try {
            BrowserDriver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
