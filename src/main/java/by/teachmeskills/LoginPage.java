package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    static final String EMAIL = "pavelcurikov090@gmail.com";
    static final String PASSWORD = "BiVdj5MuB5b73RC";
    static final By ERROR_EMAIL = By.xpath("//li[text()='An email address required.']");
    static final By ERROR_PASSWORD = By.xpath("//li[text()='Password is required.']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage loginWithValidData() {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(EMAIL);
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(PASSWORD);
        driver.findElement(By.id("SubmitLogin")).click();
        return new AccountPage(driver);
    }

    public LoginPage loginWithoutData() {
        driver.findElement(By.id("SubmitLogin")).click();
        return new LoginPage(driver);
    }

    public LoginPage loginWithoutPassword() {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(EMAIL);
        driver.findElement(By.id("SubmitLogin")).click();
        return new LoginPage(driver);
    }

    public boolean errorMessageOfEmail() {
        return driver.findElement(ERROR_EMAIL).isDisplayed();
    }

    public boolean errorMessageOfPassword() {
        return driver.findElement(ERROR_PASSWORD).isDisplayed();
    }
}
