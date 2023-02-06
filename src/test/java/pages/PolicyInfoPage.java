package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.BrowserDriver;

public class PolicyInfoPage {

    By policyInclusions = By.id("policy-inclusions");

    public void validateTextOnPage(String validateText) {
        Assert.assertEquals(validateText, BrowserDriver.driver.findElement(policyInclusions).getText());
    }
}
