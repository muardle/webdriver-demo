package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By searchField = By.id("search_form_input_homepage");
    private final By searchButton = By.id("search_button_homepage");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToUrl() {
        get("https://duckduckgo.com");
    }

    public void submitSearchQuery(String searchQuery) {
        clear(searchField);
        sendKeys(searchField, searchQuery);
        click(searchButton);
    }
}
