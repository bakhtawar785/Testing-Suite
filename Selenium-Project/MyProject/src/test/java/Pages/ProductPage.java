package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    // --- Check if free shipping is available ---
    public boolean checkFreeShipping() {
        try {
            WebElement freeShipping = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(), 'Free Shipping') or contains(text(),'free shipping')]")));
            return freeShipping.isDisplayed();
        } catch (Exception e) {
            System.out.println("Free shipping info not found.");
            return false;
        }
    }
}


