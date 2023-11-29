package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.objects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterSoulTest {
    private WebDriver driver;

    private RegisterPage registerPage;

    @BeforeAll
    public static void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();

        registerPage = new RegisterPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Create Soul without any information")
    public void createSoulWithoutAnyInformation() {
        registerPage.open();
        registerPage.clickOnCreateButton();
    }
}
