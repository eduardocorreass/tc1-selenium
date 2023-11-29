package org.example.objects;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;

public class RegisterPage {
    private final WebDriver driver;
    private final Faker faker = new Faker();

    public RegisterPage(WebDriver driver) {
       this.driver = driver;
    }

    public void open() {
        driver.get("http://127.0.0.1:5500/forge.html");
    }

    public void setName(String name){
        WebElement soulName = driver.findElement(By.id("name"));
        soulName.clear();
        soulName.sendKeys(name);
    }

    public void setDateOfDeath(String dateOfDeath){
        WebElement soulDateOfDeath = driver.findElement(By.id("dateOfDeath"));
        soulDateOfDeath.clear();
        soulDateOfDeath.sendKeys(dateOfDeath);
    }

    public void setDateBirthday(String birthday){
        WebElement soulBirthday = driver.findElement(By.id("birthday"));
        soulBirthday.clear();
        soulBirthday.sendKeys(birthday);
    }

    public void setCauseOfDeath(String causeOfDeath){
        WebElement soulCauseOfDeath = driver.findElement(By.id("causeOfDeath"));
        soulCauseOfDeath.clear();
        soulCauseOfDeath.sendKeys(causeOfDeath);
    }

    public void clickOnCreateButton() {
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
    }

    public void forgeSoul() {
        setName(faker.name().fullName());
        setDateOfDeath(faker.date().toString());
        setDateBirthday(faker.date().toString());
        setCauseOfDeath(faker.bothify("Ataque Cardíaco"));
        clickOnCreateButton();
    }

    public boolean verifySuccess(String id){
        try {
            driver.findElement(By.cssSelector(id));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
