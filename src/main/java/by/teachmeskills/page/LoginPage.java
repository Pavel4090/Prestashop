package by.teachmeskills.page;

import by.teachmeskills.util.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LoginPage extends BasePage {

    @FindBy(id = "SubmitLogin")
    @CacheLookup
    private WebElement btnSignIn;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement passwordElement;

    Properties properties = PropertiesLoader.loadProperties();
    String login = properties.getProperty("login");
    String password = properties.getProperty("password");

    static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-danger']//ol//li");

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountPage loginWithValidData() {
        email.sendKeys(login);
        passwordElement.sendKeys(password);
        btnSignIn.click();
        return new AccountPage(driver);
    }

    public LoginPage loginWithoutData() {
        btnSignIn.click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithoutPassword() {
        email.sendKeys(login);
        btnSignIn.click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithWrongPassword() {
        email.sendKeys(login);
        passwordElement.sendKeys("63574321");
        btnSignIn.click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithWrongEmail() {
        email.sendKeys("tester12345657890");
        passwordElement.sendKeys(password);
        btnSignIn.click();
        return new LoginPage(driver);
    }

    public String errorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
