package by.teachmeskills.page;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//span[text()='My addresses']")
    @CacheLookup
    private WebElement btnToAddress;
    static final By ACCOUNT_TITLE = By.xpath("//h1[text()='My account']");
    static final String POST_CODE = "12345";

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountPageOpened() {
        return driver.findElement(ACCOUNT_TITLE).isDisplayed();
    }

    public AddressPage addNewAddressWithRequiredFields() {
        Faker faker = new Faker();
        String phoneNumber1 = String.valueOf(faker.phoneNumber().cellPhone());
        String name = String.valueOf(faker.name().firstName());
        String lastName = String.valueOf(faker.name().lastName());
        String alias = String.valueOf(faker.funnyName().name());
        String address = String.valueOf(faker.address().streetAddress());
        String cityName = String.valueOf(faker.address().cityName());
        btnToAddress.click();
        driver.findElement(By.xpath("//span[text()='Add a new address']")).click();
        driver.findElement(By.id("firstname")).sendKeys(name);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("address1")).sendKeys(address);
        driver.findElement(By.id("postcode")).sendKeys(POST_CODE);
        driver.findElement(By.id("city")).sendKeys(cityName);
        driver.findElement(By.id("id_country")).click();
        driver.findElement(By.xpath("//option[@value='216']")).click();
        driver.findElement(By.id("phone")).sendKeys("+" + phoneNumber1);
        driver.findElement(By.id("id_state")).click();
        driver.findElement(By.xpath("//option[@value='321']")).click();
        driver.findElement(By.id("alias")).sendKeys(alias);
        driver.findElement(By.id("submitAddress")).click();
        return new AddressPage(driver);
    }

    public AddressPage goToAddressPage() {
        btnToAddress.click();
        return new AddressPage(driver);
    }

    public ProductsPage goToProductsPage() {
        driver.findElement(By.xpath("//div[@id='header_logo']")).click();
        return new ProductsPage(driver);
    }
}
