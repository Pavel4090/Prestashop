package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkProduct() {
        driver.findElement(By.xpath("//a[text()='Faded Short Sleeve T-shirts']")).isDisplayed();
        driver.findElement(By.xpath("//span[text()='In stock']")).isDisplayed();
        return new CartPage(driver);
    }

    public CheckoutPage goToCheckout() {
        driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")).click();
        return new CheckoutPage(driver);
    }
}
