package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final String PRODUCT_IN_THE_CART_LOCATOR = "//p[@class='product-name']/a[text()='%s']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkProductName(String productName) {
        By fullLocator = By.xpath(String.format(PRODUCT_IN_THE_CART_LOCATOR, productName));
        driver.findElement(fullLocator).isDisplayed();
        return new CartPage(driver);
    }

    public CheckoutPage goToCheckout() {
        driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")).click();
        return new CheckoutPage(driver);
    }

    public String getTotalProducts() {
        return driver.findElement(By.xpath("//td[@class='cart_total']//span[@class='price']")).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(By.xpath("//span[@id='total_price']")).getText();
    }

    public String getItemPrice() {
        return driver.findElement(By.xpath("//tr[@class='cart_item last_item first_item address_7424 odd']//td[@data-title='Unit price']//span//span[@class='price']")).getText();
    }
}
