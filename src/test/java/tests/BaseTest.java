package tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PageTitleUtils;


import static org.assertj.core.api.Assertions.assertThat;


public class BaseTest {

    protected static final String BASE_URL = "http://automationpractice.com/index.php";
    protected WebDriver driver;

    // przed wszystkimi testami
    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }


    // po kazdym tescie
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
