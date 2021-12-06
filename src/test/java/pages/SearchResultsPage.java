package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {
    private final By firstSearchResult = By.id("r1-0");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstSearchResult() {
        return getText(firstSearchResult);
    }

    public String getPageTitle() {
        return getTitle();
    }

    public String getPageUrl() {
        return getCurrentUrl();
    }
}
