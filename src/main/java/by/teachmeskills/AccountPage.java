package by.teachmeskills;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    static final By ACCOUNT_TITLE = By.xpath("//h1[text()='My account']");
    static final By ADDRES_TITLE = By.xpath("//h1[text()='My addresses']");
    static final String NAME = "Pavel";
    static final String LAST_NAME = "Ivanovich";
    static final String ADDRESS = "Wall st.";
    static final String POST_CODE = "12345";
    static final String CITY = "New York";
    static final String ALIAS = "For me";


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountPageOpened() {
        return driver.findElement(ACCOUNT_TITLE).isDisplayed();
    }

    public boolean isAddressPageOpened() {
        return driver.findElement(ADDRES_TITLE).isDisplayed();
    }

    public AccountPage addNewAddressWithRequiredFields() {
        Faker faker = new Faker();
        String phoneNumber1 = String.valueOf(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//span[text()='Add my first address']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(NAME);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(LAST_NAME);
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(ADDRESS);
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(POST_CODE);
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(CITY);
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("+" + phoneNumber1);
        driver.findElement(By.xpath("//select[@id='id_state']")).click();
        driver.findElement(By.xpath("//option[@value='32']")).click();
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(ALIAS);
        driver.findElement(By.id("submitAddress")).click();
        return new AccountPage(driver);
    }
}
