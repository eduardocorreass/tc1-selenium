package org.example.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListPage {
    private final WebDriver driver;
    public ListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://127.0.0.1:5500/index.html");
    }

    public boolean verifyIfListIsEmpty() {
        String path = String.format("//tbody/tr[%d]/td", 1);
        return driver.findElements(By.xpath(path)).isEmpty();
    }

    public void clickOnDeleteButton() {
        driver.findElement(By.cssSelector(".btn.btn-danger.delete-soul")).click();
    }
}