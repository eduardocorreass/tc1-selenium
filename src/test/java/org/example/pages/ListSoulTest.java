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

    @Test
    @DisplayName("List Should Not Be Empty")
    public void listShouldNotBeEmpty() {
        registerPage.open();

        registerPage.setName("Fabio");
        registerPage.setDateOfDeath("2023-11-15");
        registerPage.setDateBirthday("2023-01-15");
        registerPage.setCauseOfDeath("Ataque Cardíaco");
        registerPage.clickOnCreateButton();

        listPage.open();

        assertFalse(listPage.verifyIfListIsEmpty());
    }

    @Test
    @DisplayName("Should Release Soul")
    public void ShouldReleaseSoul() {
        registerPage.open();

        registerPage.setName("Fabio");
        registerPage.setDateOfDeath("2023-11-15");
        registerPage.setDateBirthday("2023-01-15");
        registerPage.setCauseOfDeath("Ataque Cardíaco");
        registerPage.clickOnCreateButton();

        listPage.open();

        listPage.clickOnDeleteButton();

        listPage.clickOnConfirmButton();

        assertTrue(listPage.verifyIfListIsEmpty());
    }

    @Test
    @DisplayName("Should Not Release Soul")
    public void ShouldNotReleaseSoul() {
        registerPage.open();

        registerPage.setName("Rodrigo");
        registerPage.setDateOfDeath("2023-07-15");
        registerPage.setDateBirthday("2004-01-15");
        registerPage.setCauseOfDeath("Queimadura");
        registerPage.clickOnCreateButton();

        listPage.open();

        listPage.clickOnDeleteButton();

        listPage.clickOnDontReleaseButoon();

        assertFalse(listPage.verifyIfListIsEmpty());
    }
}
