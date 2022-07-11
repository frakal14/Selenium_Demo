package tests;

import enums.Country;
import enums.State;
import model.RegisterForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseTest {

    private RegistrationPage registrationPage;


    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void userIsAbleToRegister() {
        registrationPage.openRegistrationFormPage();
        RegisterForm registerForm = new RegisterForm();
        registerForm.setFirstNameCustomer("Karol");
        registerForm.setLastNameCustomer("Fraczek");
        registerForm.setEmail("");
        registerForm.setPassword("Password123!");
        registerForm.setCompany("Test_Company");
        registerForm.setAddress("Marburger Strasse 13");
        registerForm.setCity("New York");
        registerForm.setState(State.NEW_YORK);
        registerForm.setPostalCode("00000");
        registerForm.setCountry(Country.UNITED_STATES);
        registerForm.setAdditionalInformation("Additional Test");
        registerForm.setHomePhone("123123123");
        registerForm.setMobilePhone("321321321");
        registerForm.setAddressAlias("MyAddress");
        registrationPage.sendRegistrationForm(registerForm);
        assertThat(registrationPage.myAccountTitle().equals("My account"));
    }



}
