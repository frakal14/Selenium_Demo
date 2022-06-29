package pages;

import model.Message;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class ContactUsFormPage extends BasePage {


    public ContactUsFormPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement sendButton;

    @FindBy(className = "alert-danger")
    WebElement messageFailureAlert;

    @FindBy(className = "alert-success")
    WebElement messageSuccessAlert;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "id_contact")
    WebElement subjectSelect;

    @FindBy(id = "id_order")
    WebElement orderReferenceInput;

    @FindBy(id = "message")
    WebElement messageTextArea;

    public void clickOnSendButton() {
        sendButton.click();
    }

    public boolean isRedAlertBoxDisplayed() {
        return isAlertBoxDisplayed(messageFailureAlert);
    }

    public boolean isGreenAlertBoxDisplayed() {

        return isAlertBoxDisplayed(messageSuccessAlert);
    }

    private boolean isAlertBoxDisplayed(WebElement box) {
        // ExplicitWait - CZEKA NA KONKRETNY ELEMENT Z NASZYM WARUNKIEM
        // ImplicitWait - GLOBALNY IMPLICIT WAIT DLA WSZYSTKICH ELEMENTOW
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(box));

        boolean isDisplayed = false;
        try {
            isDisplayed = box.isDisplayed();
        } catch (NoSuchElementException e) {
        }

        return isDisplayed;
    }

    public void enterEmail(String email) {

        emailInput.sendKeys(email);
    }

    public void sendContactUsForm(Message message) {
        Select subject = new Select(subjectSelect);
        subject.selectByVisibleText(message.getSubject().getValue());
        emailInput.sendKeys(message.getEmail());
        orderReferenceInput.sendKeys(message.getOrderReference());
        messageTextArea.sendKeys(message.getMessage());
        sendButton.click();
    }


}
