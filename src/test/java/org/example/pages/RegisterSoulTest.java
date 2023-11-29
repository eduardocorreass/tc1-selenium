package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.objects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class RegisterSoulTest {
    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeAll
    public static void setupWebDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();

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

        new WebDriverWait(driver, Duration.ofSeconds(5));

        assertFalse(registerPage.verifySuccess(".swal2-popup.swal2-modal.swal2-icon-success.swal2-show"));
    }
}
