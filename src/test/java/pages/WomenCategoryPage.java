package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


public class WomenCategoryPage extends BasePage {

    public WomenCategoryPage(WebDriver driver) {

        super(driver);
    }


    @FindBy(className = "category-name")
    WebElement womenHeroBlock;

    @FindBy(css = ".product_list .content_price")
    List<WebElement> womenProductsPriceList;

    @FindBy(id = "block_top_menu")
    List<WebElement> navigationElements;

    // Lista produktow
//    @FindBy(className = "category-name")
//    WebElement womenHeroBlock;


    public WebElement getWomenHeroBlock() {
        return
                womenHeroBlock;
    }


    public List<String> getWomenProductPriceList() {
        return womenProductsPriceList.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());

    }
}
