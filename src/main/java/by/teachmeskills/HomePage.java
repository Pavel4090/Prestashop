package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.PropertiesLoader;

import java.util.Properties;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openSite() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url"));
        return new HomePage(driver);
    }

    public LoginPage goToLoginPage() {
        driver.findElement(By.xpath("//a[@class='login']")).click();
        return new LoginPage(driver);
    }
}
