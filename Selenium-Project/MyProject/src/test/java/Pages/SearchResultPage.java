package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // --- Apply Brand Filter ---
    public void selectBrand(String brandName) {
        try {
            // Scroll into view first (helps with lazy-loading)
            WebElement brandLabel = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//label[contains(.,'" + brandName + "')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandLabel);

            // Click the checkbox
            wait.until(ExpectedConditions.elementToBeClickable(brandLabel)).click();

            // Click the Apply button (if available)
            WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Apply')]")));
            applyButton.click();

        } catch (Exception e) {
            System.out.println("Error selecting brand '" + brandName + "': " + e.getMessage());
        }
    }

    // --- Set Min Price ---
    public void setMinPrice(String minPrice) {
        WebElement minPriceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Min']")));
        minPriceInput.clear();
        minPriceInput.sendKeys(minPrice);
    }

    // --- Set Max Price ---
    public void setMaxPrice(String maxPrice) {
        WebElement maxPriceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Max']")));
        maxPriceInput.clear();
        maxPriceInput.sendKeys(maxPrice);
    }

    // --- Click Apply on Price Filter ---
    public void applyPriceFilter() {
        WebElement priceApplyBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Apply')]")));
        priceApplyBtn.click();
    }

    // --- Count the number of product results ---
    public int countResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".gridItem--Yd0sa")));
        List<WebElement> products = driver.findElements(By.cssSelector(".gridItem--Yd0sa"));
        return products.size();
    }

    // --- Click on first product ---
    public void clickFirstProduct() {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".gridItem--Yd0sa")));
        if (!products.isEmpty()) {
            products.get(0).click();
        } else {
            System.out.println("No products found to click.");
        }
    }
}


