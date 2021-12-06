package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import webdriver.Browser;
import webdriver.Driver;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    private final Browser browser = Browser.valueOf(System.getProperty("browser"));

    @BeforeTest
    public void setup() {
        driver = Driver.initialise(browser);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        Driver.quit(driver);
    }
}
