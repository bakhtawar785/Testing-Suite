package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.SearchResultPage;
import Pages.ProductPage;

public class DarazTest {

    @Test
    public void testDarazProductSearchFlow() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\H.T\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  to Daraz
        driver.get("https://www.daraz.pk/");

        // Search for a product
        HomePage homePage = new HomePage(driver);
        homePage.searchFor("smartphone");

        // Apply filters
        SearchResultPage resultsPage = new SearchResultPage(driver);
        resultsPage.selectBrand("Apple");
        resultsPage.setMinPrice("500");
        resultsPage.setMaxPrice("5000");
        resultsPage.applyPriceFilter();

        // Small wait for results to load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Count the number of products and validate
        int productCount = resultsPage.countResults();
        System.out.println("Product Count: " + productCount);
        Assert.assertTrue(productCount > 0, "No products found in results.");

        // Click on first product
        resultsPage.clickFirstProduct();

        // Verify if free shipping is available
        ProductPage productPage = new ProductPage(driver);
        boolean isFreeShipping = productPage.checkFreeShipping();
        Assert.assertTrue(isFreeShipping, "Free shipping not available for this product.");

        driver.quit();
    }
}

