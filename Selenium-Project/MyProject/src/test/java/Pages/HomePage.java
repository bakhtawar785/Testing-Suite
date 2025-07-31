package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Search for a product ---
    public void searchFor(String productName) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys(productName);

        WebElement searchButton = driver.findElement(By.className("search-box__button--1oH7"));
        searchButton.click();
    }
}

