package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderMenu extends BasePage {

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public ProductsPage changeLangToEn() {
        driver.findElement(By.xpath("//div[@id='languages-block-top']")).click();
        driver.findElement(By.xpath("//ul[@id='first-languages']//span[text()='English']")).click();
        return new ProductsPage(driver);
    }

    public boolean logout() {
        boolean userLogout;
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();
        WebElement element = driver.findElement(By.xpath("//a[contains (text(),'Sign in')]"));
        userLogout = element.isDisplayed();
        return userLogout;
    }

    public LoginPage signIn() {
        driver.findElement(By.xpath("//a[contains (text(),'Sign in')]")).click();
        return new LoginPage(driver);
    }

    public ProductsPage changeCurrency() {
        driver.findElement(By.xpath("//form[@id='setCurrency']//div[@class='current']")).click();
        driver.findElement(By.xpath("//li//a[@title='Доллар']")).click();
        return new ProductsPage(driver);
    }
}
