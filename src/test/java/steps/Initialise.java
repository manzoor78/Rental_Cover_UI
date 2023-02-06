package steps;

import io.cucumber.java.en.Given;
import utilities.ReadProperties;

import java.io.IOException;

public class Initialise {

    public static String homePageURL;
    public static String browser;
    public ReadProperties propertyFile = new ReadProperties();

    /**
     * This method initialises all variables defined in the config file.
     *
     * @throws IOException
     */
    public void initialiseVariables() throws IOException {
        propertyFile.loadPropertyFile();

        if (propertyFile.getURL() != null) {
            homePageURL = propertyFile.getURL();
        } else {
            homePageURL = "not defined";
        }

        if (propertyFile.getBrowser() != null) {
            browser = propertyFile.getBrowser();
        } else {
            browser = "not defined";
        }
    }

    @Given("^User Initializes Tests$")
    public void initialiseTest() throws IOException {
        initialiseVariables();
    }

}
