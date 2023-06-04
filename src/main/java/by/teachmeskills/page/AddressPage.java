package by.teachmeskills.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage extends BasePage {

    static final By ADDRESS_TITLE = By.xpath("//h1[text()='My addresses']");
    static final By BTN_DELETE = By.xpath("//a[@title='Delete']");

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddressPageOpened() {
        WebElement title = driver.findElement(ADDRESS_TITLE);
        return title.isDisplayed();
    }

    public boolean isAddressCreate() {
        WebElement btn = driver.findElement(BTN_DELETE);
        return btn.isDisplayed();
    }


    public AddressPage isAddressCreated() {
        WebElement btn = driver.findElement(BTN_DELETE);
        btn.isDisplayed();
        return new AddressPage(driver);
    }

    public boolean isAddressDeleted() {
        boolean btn;
        WebElement alert = driver.findElement(By.xpath("//p[text()='No addresses are available.\u00A0']"));
        btn = alert.isDisplayed();
        return btn;
    }

    public AddressPage deleteAddress() {
        driver.findElement(BTN_DELETE).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new AddressPage(driver);
    }

    public ProductsPage goToProductsPage() {
        driver.findElement(By.xpath("//div[@id='header_logo']")).click();
        return new ProductsPage(driver);
    }

    public AccountPage goToAccountPage() {
        return new AccountPage(driver);
    }
}
