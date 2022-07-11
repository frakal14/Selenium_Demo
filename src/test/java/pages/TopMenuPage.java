package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(linkText = "Sign in")
    WebElement signInLink;


    public void clickOnContactUsLink() {
        wait.until(ExpectedConditions.visibilityOf(contactUsLink));
        contactUsLink.click();
    }

    public void clickOnSignInLink() {
        signInLink.click();
    }


}
