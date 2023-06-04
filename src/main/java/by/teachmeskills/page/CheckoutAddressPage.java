package by.teachmeskills.page;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutAddressPage extends BasePage{

    static final String POST_CODE = "12345";

    private static final Faker FAKER = new Faker();
    private static final String PHONE_NUMBER_1 = String.valueOf(FAKER.phoneNumber().cellPhone());
    private static final String NAME = String.valueOf(FAKER.name().firstName());
    private static final String LAST_NAME = String.valueOf(FAKER.name().lastName());
    private static final String ALIAS = String.valueOf(FAKER.funnyName().name());
    private static final String ADDRESS = String.valueOf(FAKER.address().streetAddress());
    private static final String CITY_NAME = String.valueOf(FAKER.address().cityName());


    public CheckoutAddressPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutShippingPage nextCheckout() {
        driver.findElement(By.xpath("//button[@name='processAddress']")).click();
        return new CheckoutShippingPage(driver);
    }

    public void addNewAddress() {
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
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
    }
}
