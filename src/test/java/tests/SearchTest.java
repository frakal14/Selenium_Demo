package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        searchPage = new SearchPage(driver);
    }

    @Test
    public void searchShouldHaveResults() {
        searchPage.searchInput();
        assertThat(searchPage.getSearchResultText().equals("BLOUSE"));
    }

    @Test
    public void searchBlouseProduct() {
        searchPage.searchInput();
        assertThat(searchPage.getSearchResultProductName()).isEqualTo("Blouse");
        assertThat(searchPage.getSearchResultProductPrice()).isEqualTo("$27.00");
    }


}
