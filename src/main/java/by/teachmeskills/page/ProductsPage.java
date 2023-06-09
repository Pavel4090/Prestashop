package by.teachmeskills.page;

import by.teachmeskills.util.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class ProductsPage extends BasePage {

    private static final String PRODUCT_ON_PAGE_LOCATOR = "//div[@class='tab-content']//a[@title='%s' and @class='product-name']";
    private static final By PROCEED_TO_CHECKOUT = By.xpath("//div[@class='button-container']//a[@title='Proceed to checkout']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        String baseUrl = properties.getProperty("base.url");
        driver.get(baseUrl);
        return new ProductsPage(driver);
    }

    public HeaderMenu getHeaderMenu() {

        return new HeaderMenu(driver);
    }

    public LoginPage goToLoginPage() {
        driver.findElement(By.xpath("//a[@class='login']")).click();
        return new LoginPage(driver);
    }

    public CartPage addItemToCartAndGoToCart() {
        driver.findElement(By.xpath("//h5[@itemprop='name']//a[@title='Faded Short Sleeve T-shirts']")).click();
        driver.findElement(By.xpath("//button[@name='Submit']")).click();
        driver.findElement(PROCEED_TO_CHECKOUT).click();
        return new CartPage(driver);
    }

    public CartPage addItemInCart(String productName) {
        By fullLocator = By.xpath(String.format(PRODUCT_ON_PAGE_LOCATOR, productName));
        driver.findElement(fullLocator).click();
        driver.findElement(By.xpath("//button[@name='Submit']")).click();
        WebElement btn = driver.findElement(By.xpath("//div[@class='clearfix']//div[@class='button-container']//a[@title='Proceed to checkout']"));
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(btn)).click();
        return new CartPage(driver);
    }

    public ProductsPage addItemInTheCart(String productName) {
        By fullLocator = By.xpath(String.format(PRODUCT_ON_PAGE_LOCATOR, productName));
        driver.findElement(fullLocator).click();
        driver.findElement(By.xpath("//button[@name='Submit']")).click();
        driver.findElement(By.xpath("//div[@class='shopping_cart']")).click();
        driver.findElement(By.xpath("//div[@id='header_logo']")).click();
        return new ProductsPage(driver);
    }

    public ItemPage goToItem(String itemName) {
        By fullLocator = By.xpath(String.format(PRODUCT_ON_PAGE_LOCATOR, itemName));
        driver.findElement(fullLocator).click();
        return new ItemPage(driver);
    }

    public ItemPage searchItem() {
        driver.findElement(By.id("search_query_top")).sendKeys("Prin");
        WebElement element = driver.findElement(By.xpath("//ul//li[4]/strong[text()='Prin']"));
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element)).click();
        return new ItemPage(driver);
    }

    public boolean searchNullItem() {
        boolean emptySearch;
        driver.findElement(By.id("search_query_top")).sendKeys("");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        WebElement element = driver.findElement(By.xpath("//p[contains (text(),'Please enter a search keyword')]"));
        emptySearch = element.isDisplayed();
        return emptySearch;
    }

    public ItemPage searchByFullName(String productName) {
        driver.findElement(By.id("search_query_top")).sendKeys(productName);
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        driver.findElement(By.xpath("//h5[@itemprop='name']//a[@title='Printed Dress']")).click();
        return new ItemPage(driver);
    }

    public ProductsPage wrongSearch(String message) {
        driver.findElement(By.id("search_query_top")).sendKeys(message);
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        return new ProductsPage(driver);
    }

    public String checkAlertMessage() {
        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='center_column']//p"));
        return alertMessage.getText();
    }

    public CartPage goToCart() {
        driver.findElement(By.xpath("//div[@class='shopping_cart']//span[text()='Product']")).click();
        return new CartPage(driver);
    }

    public String getProductPrice() {
        return driver.findElement(By.xpath("//span[@itemprop='price']")).getText();
    }

    public String getItemName() {
        return driver.findElement(By.xpath("//td[@class='cart_description']//p[@class='product-name']//a")).getText();
    }
}
