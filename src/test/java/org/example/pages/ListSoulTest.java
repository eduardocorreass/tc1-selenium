package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.objects.ListPage;
import org.example.objects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListSoulTest {
    private WebDriver driver;
    private RegisterPage registerPage;
    private ListPage listPage;

    @BeforeAll
    public static void setupWebDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        listPage = new ListPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("List Should Be Empty")
    public void listShouldBeEmpty() {
        listPage.open();

        assertTrue(listPage.verifyIfListIsEmpty());
    }
}
