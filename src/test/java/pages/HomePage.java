package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BrowserDriver;

public class HomePage {

    By homePageLogo = By.xpath("//a[@href=\"https://www.rentalcover.com\"]");
    By acceptButton = By.xpath("//button[@aria-label=\"ACCEPT\"]");

    By pickUpDateFirst = By.xpath("//div[@class=\"ui-datepicker-group ui-datepicker-group-first\"]");

    By pickUpDateLast = By.xpath("//div[@class=\"ui-datepicker-group ui-datepicker-group-last\"]");

    /**
     * Returns web element found with placeholder name
     *
     * @param placeholderName
     * @return
     */
    private WebElement getElementByPlaceholderName(String placeholderName) {
        return BrowserDriver.driver.findElement(By.xpath("//input[@placeholder=\"" + placeholderName + "\"]"));
    }

    public void enterText(String fieldName, String fieldValue) {
        getElementByPlaceholderName(fieldName).click();
        getElementByPlaceholderName(fieldName).sendKeys(fieldValue);
        getElementByPlaceholderName(fieldName).sendKeys(Keys.ENTER);

    }

    public void assertOnHomePage() {
        Assert.assertTrue(BrowserDriver.driver.findElement(homePageLogo).isDisplayed());
    }

    public void clickOnAccept() {
        BrowserDriver.driver.findElement(acceptButton).click();
    }

    /**
     * Clicks on Calender and selects the date
     *
     * @param fieldName
     * @param fieldValue
     * @throws InterruptedException
     */
    public void clickOnCalenderAndSelectDate(String fieldName, String fieldValue) throws InterruptedException {
        String[] dateValues = fieldValue.split("-");
        String day = dateValues[0];
        String month = dateValues[1];
        String year = dateValues[2];

        getElementByPlaceholderName(fieldName).click();
        selectDate(day, month, year);

    }

    private void selectDate(String day, String month, String year) throws InterruptedException {

        String currentMonthFirst = BrowserDriver.driver.findElement(pickUpDateFirst).findElement(By.className("ui-datepicker-month")).getText();
        String currentYearFirst = BrowserDriver.driver.findElement(pickUpDateFirst).findElement(By.className("ui-datepicker-year")).getText();
        String currentMonthLast = BrowserDriver.driver.findElement(pickUpDateLast).findElement(By.className("ui-datepicker-month")).getText();
        String currentYearLast = BrowserDriver.driver.findElement(pickUpDateLast).findElement(By.className("ui-datepicker-year")).getText();

        if (month.equalsIgnoreCase(currentMonthFirst) && year.equalsIgnoreCase(currentYearFirst)) {
            BrowserDriver.driver.findElement(pickUpDateFirst).findElement(By.xpath(".//td/a[text()=\"" + day + "\"]")).click();
        } else if (month.equalsIgnoreCase(currentMonthLast) && year.equalsIgnoreCase(currentYearLast)) {
            BrowserDriver.driver.findElement(pickUpDateLast).findElement(By.xpath(".//td/a[text()=\"" + day + "\"]")).click();
        } else {
            BrowserDriver.driver.findElement(By.xpath("//a[@title=\"Next\"]")).click();
            selectDate(day, month, year);
        }
    }

    public void clickButton(String buttonName) {
        BrowserDriver.driver.findElement(By.xpath("//button/span[text()=\"" + buttonName + "\"]")).click();
    }

}
