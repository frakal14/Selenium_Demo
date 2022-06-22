package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContactUsFormPage extends BasePage {


    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement sendButton;

    @FindBy(className = "alert-danger")
    WebElement alertBox;

    @FindBy(id = "email")
    WebElement emailInput;

    public void clickOnSendButton() {
        sendButton.click();
    }

    public boolean isAlertBoxDisplayed() {
        // ExplicitWait - CZEKA NA KONKRETNY ELEMENT Z NASZYM WARUNKIEM
        // ImplicitWait - GLOBALNY IMPLICIT WAIT DLA WSZYSTKICH ELEMENTOW
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(alertBox));

        boolean isDisplayed = false;
        try {
            isDisplayed = alertBox.isDisplayed();
        } catch (NoSuchElementException e) {
        }

        return isDisplayed;
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }


}
