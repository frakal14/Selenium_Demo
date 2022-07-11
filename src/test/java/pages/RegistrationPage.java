package pages;

import com.github.javafaker.Faker;
import model.RegisterForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    private final TopMenuPage topMenuPage;

    public RegistrationPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }
    // Authenticate page selectors:
    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(id = "email_create")
    WebElement createAccountEmailInput;
    // Registration form selectors:

    //     YOUR PERSONAL INFORMATION SELECTORS
    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement radioButtonMr;

    @FindBy(id = "customer_firstname")
    WebElement firstNameCustomerInput;

    @FindBy(id = "customer_lastname")
    WebElement lastNameCustomerInput;

    @FindBy(id = "email")
    WebElement emailCustomerInput;

    @FindBy(id = "passwd")
    WebElement passwordCustomerInput;

    @FindBy(id = "days")
    WebElement dayDateOfBirthDropDown;

    @FindBy(id = "months")
    WebElement monthDateOfBirthDropDown;

    @FindBy(id = "years")
    WebElement yearDateOfBirthDropDown;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement specialOffersCheckbox;

    // YOUR ADDRESS SELECTORS:

    @FindBy(id = "company")
    WebElement companyInput;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "id_state")
    WebElement stateDropDown;

    @FindBy(id = "postcode")
    WebElement postalCodeInput;

    @FindBy(id = "id_country")
    WebElement countryDropDown;

    @FindBy(id = "other")
    WebElement additionalInformationInput;

    @FindBy(id = "phone")
    WebElement homePhoneInput;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    WebElement addressAliasInput;

    @FindBy(id = "submitAccount")
    WebElement registerSubmitButton;

    @FindBy(className = "page-heading")
    WebElement myAccountTitle;


    public void clickOnCreateAnAccount() {
        createAccountButton.click();
    }

    public void createAccountEmailInput() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        createAccountEmailInput.sendKeys(email);
    }

    public void openRegistrationFormPage() {
        wait.until(ExpectedConditions.visibilityOf(topMenuPage.signInLink));
        topMenuPage.clickOnSignInLink();
        clickOnCreateAnAccount();
        createAccountEmailInput();
        clickOnCreateAnAccount();
    }

    public void sendRegistrationForm(RegisterForm registerForm) {
        wait.until(ExpectedConditions.visibilityOf(radioButtonMr));
        radioButtonMr.click();
        firstNameCustomerInput.sendKeys(registerForm.getFirstNameCustomer());
        lastNameCustomerInput.sendKeys(registerForm.getLastNameCustomer());
        emailCustomerInput.sendKeys(registerForm.getEmail());
        passwordCustomerInput.sendKeys(registerForm.getPassword());

//         TODO: change selectByIndex TO MONTH enums
        Select day = new Select(dayDateOfBirthDropDown);
        day.selectByIndex(1);

        Select month = new Select(monthDateOfBirthDropDown);
        month.selectByIndex(1);

        Select year = new Select(yearDateOfBirthDropDown);
        year.selectByIndex(23);

        newsletterCheckbox.click();
        companyInput.sendKeys(registerForm.getCompany());
        address.sendKeys(registerForm.getAddress());
        cityInput.sendKeys(registerForm.getAddress());
        Select state = new Select(stateDropDown);
        state.selectByVisibleText(registerForm.getState().getValue());
        postalCodeInput.sendKeys(registerForm.getPostalCode());
        Select country = new Select(countryDropDown);
        country.selectByVisibleText(registerForm.getCountry().getValue());
        additionalInformationInput.sendKeys(registerForm.getAdditionalInformation());
        homePhoneInput.sendKeys(registerForm.getHomePhone());
        mobilePhoneInput.sendKeys(registerForm.getMobilePhone());
        addressAliasInput.sendKeys(registerForm.getAddressAlias());
        registerSubmitButton.click();
    }

    public String myAccountTitle(){
        return myAccountTitle.getText();
    }

    public void test() {
      wait.until(ExpectedConditions.visibilityOf(radioButtonMr));
        radioButtonMr.click();
    }



}
