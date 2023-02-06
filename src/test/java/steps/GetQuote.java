package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.PolicyInfoPage;
import utilities.BrowserDriver;
import utilities.CommonUtils;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class GetQuote {

    final static Logger logger = Logger.getLogger(String.valueOf(GetQuote.class));
    HomePage homePage = new HomePage();
    PolicyInfoPage policyInfoPage = new PolicyInfoPage();

    @Given("User Navigates to Home Page")
    public void userNavigateToHomePage() {
        BrowserDriver.browser(Initialise.browser);
        BrowserDriver.driver.manage().window().maximize();
        BrowserDriver.driver.get(Initialise.homePageURL);
        homePage.assertOnHomePage();
        CommonUtils.waitImplicitlyInSeconds(30);
        homePage.clickOnAccept();
    }

    @After
    public void after() {
        BrowserDriver.driver.quit();
    }

    @And("User Enter Fields.Text")
    public void userEnterFieldsText(DataTable dataTableFieldParameters) {
        List<Map<String, String>> listParameters = dataTableFieldParameters.asMaps(String.class, String.class);

        if (listParameters == null
                || listParameters.size() == 0
                || listParameters.contains(null)
                || listParameters.contains("")) {
            logger.severe("One or more of the parameters passed is empty.");
            Assert.fail();
        } else {
            for (Map<String, String> listParameter : listParameters) {
                homePage.enterText(listParameter.get("FieldName"), listParameter.get("FieldValue"));
            }

        }
    }

    @And("User Select Field.Calender")
    public void userSelectFieldCalender(DataTable dataTableFieldParameters) throws InterruptedException {
        List<Map<String, String>> listParameters = dataTableFieldParameters.asMaps(String.class, String.class);

        if (listParameters == null
                || listParameters.size() == 0
                || listParameters.contains(null)
                || listParameters.contains("")) {
            logger.severe("One or more of the parameters passed is empty.");
            Assert.fail();
        } else {
            for (Map<String, String> listParameter : listParameters) {
                homePage.clickOnCalenderAndSelectDate(listParameter.get("FieldName"), listParameter.get("FieldValue"));
            }

        }
    }

    @And("User Click Button.{string}")
    public void userClickButton(String buttonName) throws InterruptedException {
        homePage.clickButton(buttonName);
    }

    @Then("User Validate {string}")
    public void userValidate(String validateText) {
        policyInfoPage.validateTextOnPage(validateText);
    }
}
