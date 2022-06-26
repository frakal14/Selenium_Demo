package tests;

import enums.MessageSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsFormPage;
import pages.TopMenuPage;
import utils.PageTitleUtils;
import model.Message;



import static org.assertj.core.api.Assertions.assertThat;

public class ContactUsTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private ContactUsFormPage contactUsFormPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);
    }

    @Test
    public void shouldNotAllowToSEndEmptyContactUsForm() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.clickOnSendButton();

        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }


    @Test
    public void shouldNotAllowToSendContactUsFormWithEmailOnly() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.enterEmail("tester@example.com");
        contactUsFormPage.clickOnSendButton();

        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldSendContactUsFormWithValidData() {
        topMenuPage.clickOnContactUsLink();

        Message message = new Message();
        message.setSubject(MessageSubject.WEBMASTER);
        message.setEmail("tester@example.com");
        message.setOrderReference("123");
        message.setMessage("Jakas Wiadomosc");
        contactUsFormPage.sendContactUsForm(message);

        assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }


}
