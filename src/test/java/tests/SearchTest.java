package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @BeforeTest
    public void setupPages() {
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void submitSearchQueryTest() {
        homePage.goToUrl();
        homePage.submitSearchQuery("Selenium WebDriver");
        assertThat(searchResultsPage.getPageUrl()).contains("https://duckduckgo.com/?q=Selenium+WebDriver");
        assertThat(searchResultsPage.getPageTitle()).isEqualTo("Selenium WebDriver at DuckDuckGo");
        assertThat(searchResultsPage.getFirstSearchResult()).contains("https://www.selenium.dev");
    }
}
