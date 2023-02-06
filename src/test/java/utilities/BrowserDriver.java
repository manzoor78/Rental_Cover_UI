package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriver {
    public static WebDriver driver = null;

    /**
     * This method initialises required browser
     * @param browser
     */
    public static void browser(String browser) {

        String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
        String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/gecko";

        try {
            if (browser.equalsIgnoreCase("firefox")) {
                System.out.println("Firefox browser selected");
                System.setProperty("webdriver.firefox.driver", firefoxDriverPath);
                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("chrome")) {
                System.out.println("Chrome browser selected");
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                driver = new ChromeDriver();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
