package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private final int timeoutDuration = 3;
    private final int pollingDuration = 1;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clear(By locator) {
        waitForElementToBePresent(locator);
        findElement(locator).clear();
    }

    protected void click(By locator) {
        waitForElementToBeClickable(locator);
        findElement(locator).click();
    }

    protected void deselectCheckbox(By locator) {
        if (isSelected(locator)) {
            click(locator);
        }
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void get(String url) {
        driver.get(url);
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getText(By locator) {
        waitForElementToBePresent(locator);
        return findElement(locator).getText();
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected void selectByValue(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }

    protected void selectByVisibleText(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByVisibleText(value);
    }

    protected void selectCheckbox(By locator) {
        if (!isSelected(locator)) {
            click(locator);
        }
    }

    protected void sendKeys(By locator, String value) {
        waitForElementToBePresent(locator);
        findElement(locator).sendKeys(value);
    }

    protected void sendKeys(By locator, Keys keys) {
        waitForElementToBePresent(locator);
        findElement(locator).sendKeys(keys);
    }

    private Boolean isSelected(By locator) {
        return findElement(locator).isSelected();
    }

    private void waitForElementToBeClickable(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutDuration))
                .pollingEvery(Duration.ofSeconds(pollingDuration));
        wait.until(ExpectedConditions.elementToBeClickable(findElement(locator)));
    }

    private void waitForElementToBePresent(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutDuration))
                .pollingEvery(Duration.ofSeconds(pollingDuration));
        wait.until(ExpectedConditions.presenceOfElementLocated((locator)));
    }
}
