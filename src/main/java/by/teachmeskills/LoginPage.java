package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id = "SubmitLogin")
    @CacheLookup
    private WebElement btnSignIn;

    @FindBy(id = "email")
    private WebElement email;

    static final String EMAIL = "pavelcurikov090@gmail.com";
    static final String PASSWORD = "BiVdj5MuB5b73RC";
    static final By ERROR_EMAIL = By.xpath("//li[text()='An email address required.']");
    static final By ERROR_PASSWORD = By.xpath("//li[text()='Password is required.']");
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountPage loginWithValidData() {
        email.sendKeys(EMAIL);
        driver.findElement(By.id("passwd")).sendKeys(PASSWORD);
        btnSignIn.click();
        return new AccountPage(driver);
    }

    public LoginPage loginWithoutData() {
        btnSignIn.click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithoutPassword() {
        email.sendKeys(EMAIL);
        btnSignIn.click();
        return new LoginPage(driver);
    }

    public boolean errorMessageOfEmail() {
        return driver.findElement(ERROR_EMAIL).isDisplayed();
    }

    public boolean errorMessageOfPassword() {
        return driver.findElement(ERROR_PASSWORD).isDisplayed();
    }
}
