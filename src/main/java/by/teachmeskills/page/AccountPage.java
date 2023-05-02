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

    private static final Faker FAKER = new Faker();
    private static final String PHONE_NUMBER_1 = String.valueOf(FAKER.phoneNumber().cellPhone());
    private static final String NAME = String.valueOf(FAKER.name().firstName());
    private static final String LAST_NAME = String.valueOf(FAKER.name().lastName());
    private static final String ALIAS = String.valueOf(FAKER.funnyName().name());
    private static final String ADDRESS = String.valueOf(FAKER.address().streetAddress());
    private static final String CITY_NAME = String.valueOf(FAKER.address().cityName());

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountPageOpened() {
        return driver.findElement(ACCOUNT_TITLE).isDisplayed();
    }

    public AddressPage addNewAddressWithRequiredFields() {
        btnToAddress.click();
        driver.findElement(By.xpath("//span[text()='Add a new address']")).click();
        driver.findElement(By.id("firstname")).sendKeys(NAME);
        driver.findElement(By.id("lastname")).sendKeys(LAST_NAME);
        driver.findElement(By.id("address1")).sendKeys(ADDRESS);
        driver.findElement(By.id("postcode")).sendKeys(POST_CODE);
        driver.findElement(By.id("city")).sendKeys(CITY_NAME);
        driver.findElement(By.id("id_country")).click();
        driver.findElement(By.xpath("//option[@value='216']")).click();
        driver.findElement(By.id("phone")).sendKeys("+" + PHONE_NUMBER_1);
        driver.findElement(By.id("id_state")).click();
        driver.findElement(By.xpath("//option[@value='321']")).click();
        driver.findElement(By.id("alias")).sendKeys(ALIAS);
        driver.findElement(By.id("submitAddress")).click();
        return new AddressPage(driver);
    }

    public HeaderMenu getHeaderMenu() {

        return new HeaderMenu(driver);
    }

    public ProductsPage goToProductsPage() {
        driver.findElement(By.xpath("//div[@id='header_logo']")).click();
        return new ProductsPage(driver);
    }

    public boolean checkedOrderHistory() {
        boolean statusDis;
        driver.findElement(By.xpath("//span[text()='Order history and details']")).click();
        driver.findElement(By.xpath("//h1[text()='Order history']")).isDisplayed();
        driver.findElement(By.xpath("//tr[@class='first_item ']//span[contains (text(),'Details')]")).click();
        WebElement status = driver.findElement(By.xpath("//span[text()='В ожидании оплаты банком']"));
        statusDis = status.isDisplayed();
        return statusDis;
    }

    public boolean checkedAddress() {
        boolean goodAddress;
        String actualAlias = driver.findElement(By.xpath("//h3[@class='page-subheading']")).getText();
        String actualPhoneNumber = driver.findElement(By.xpath("//li//span[@class='address_phone']")).getText();
        String actualAddress = driver.findElement(By.xpath("//li//span[@class='address_address1']")).getText();
        goodAddress = (ALIAS.toUpperCase()).equals(actualAlias) & ("+" + PHONE_NUMBER_1).equals(actualPhoneNumber) & ADDRESS.equals(actualAddress);
        return goodAddress;
    }
}
