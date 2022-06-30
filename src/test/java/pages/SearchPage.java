package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    private NavigationPage navigationPage;

    public SearchPage(WebDriver driver) {
        super(driver);

        navigationPage = new NavigationPage(driver);
    }


    @FindBy(xpath = "//div[@id='center_column']//h1")
    WebElement searchResultText;

    @FindBy(xpath = "//div[@id='center_column']//a[@class='product-name']")
    WebElement searchResultProductName;

    @FindBy(xpath = "(//div[@class='content_price'])[2]")
    WebElement searchResultProductPrice;

    public String getSearchResultProductPrice() {
        return searchResultProductPrice.getText();
    }

    public String getSearchResultProductName() {
        return searchResultProductName.getText();
    }

    public WebElement getSearchResultText() {
        return searchResultText;
    }

    public void searchInput() {
        navigationPage.sendSearchQuery();
    }



}
