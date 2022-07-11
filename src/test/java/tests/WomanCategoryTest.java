package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.NavigationPage;
import pages.WomenCategoryPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WomanCategoryTest extends BaseTest {

    private WomenCategoryPage womenCategoryPage;
    private NavigationPage navigationPage;


    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        womenCategoryPage = new WomenCategoryPage(driver);
        navigationPage = new NavigationPage(driver);

    }

    @Test
    public void shouldOpenWomenCategoryPage() {
        navigationPage.clickOnWomenCategoryLink();
        assertThat(womenCategoryPage.getWomenHeroBlock().isDisplayed());
    }

    @Test
    // TO DO poprawic test - liste na double oraz zrobic asercje na wartosci ujemne badz rowne 0
    public void womenProductsShouldNotHaveZeroValue() {
        navigationPage.clickOnWomenCategoryLink();

        List<String> productPrices = womenCategoryPage.getWomenProductPriceList();

        List<String> productPricesGreaterThanZero = productPrices.stream()
                .filter(el -> el.contains("00.00"))
                .collect(Collectors.toList());

        assertThat(productPricesGreaterThanZero).isEmpty();

    }


}