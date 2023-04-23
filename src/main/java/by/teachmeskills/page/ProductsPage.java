package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import by.teachmeskills.util.PropertiesLoader;

import java.util.Properties;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        String baseUrl = properties.getProperty("base.url");
        driver.get(baseUrl);
        return new ProductsPage(driver);
    }

    public HeaderMenu lookForHeader() {

        return new HeaderMenu(driver);
    }

    public LoginPage goToLoginPage() {
        driver.findElement(By.xpath("//a[@class='login']")).click();
        return new LoginPage(driver);
    }

    public CartPage addItemToCartAndGoToCart() {
      driver.findElement(By.xpath("//h5[@itemprop='name']//a[@title='Faded Short Sleeve T-shirts']")).click();
      driver.findElement(By.xpath("//button[@name='Submit']")).click();
      driver.findElement(By.xpath("//div[@class='button-container']//a[@title='Proceed to checkout']")).click();
        return new CartPage(driver);
    }

    public ItemPage addItemInCart() {
        driver.findElement(By.xpath("//h5[@itemprop='name']//a[@title='Blouse']")).click();
        driver.findElement(By.xpath("//button[@name='Submit']")).click();
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
        return new ItemPage(driver);
    }
}
