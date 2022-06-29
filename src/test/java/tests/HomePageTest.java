package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PopularItemsPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseTest {

    private PopularItemsPage popularItemsPage;
    private WebElement element;

    // przed kazadym testem
    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        popularItemsPage = new PopularItemsPage(driver);
    }

    @Test
    public void shouldSeePopularItemsOnHomePage() {
        List<String> productNames = popularItemsPage.getProductNames();

//        List<WebElement> productNamesByXpath = driver.findElements(By.xpath("//*[@id='homefeatured']//*[@class='product-name']"));
//
//        for (WebElement productName : productNamesByXpath) {
//            System.out.println(productName.getText());
//        }

//        boolean anyProductHasEmptyName = productNamesByCss.stream()
//                .anyMatch(el -> el.getText().isEmpty());
//
////        Assertions.assertThat(anyProductHasEmptyName).isFalse();

        List<String> productsWithEmptyNames = productNames.stream()
                .filter(el -> el.isEmpty())
                .collect(Collectors.toList());

        assertThat(productsWithEmptyNames).isNotEmpty();

    }


}
