package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends BasePage {

    public NavigationPage(WebDriver driver) {

        super(driver);
    }


    @FindBy(xpath = "//a[text()='Women']")
    WebElement womenCategoryLink;

    @FindBy(className = "search_query")
    WebElement searchField;

    @FindBy(className = "button-search")
    WebElement searchButton;

    public void clickOnWomenCategoryLink() {

        womenCategoryLink.click();
    }

    public void sendSearchQuery() {
        searchField.click();
        searchField.sendKeys("Blouse");
        searchButton.click();
    }




















}
