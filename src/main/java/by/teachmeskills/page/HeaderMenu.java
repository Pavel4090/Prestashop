package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenu extends BasePage{

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public ProductsPage changeLangToEn() {
        driver.findElement(By.xpath("//div[@id='languages-block-top']")).click();
        driver.findElement(By.xpath("//ul[@id='first-languages']//span[text()='English']")).click();
        return new ProductsPage(driver);
    }

    public ProductsPage changeCurrency() {
        driver.findElement(By.id("setCurrency")).click();

        return new ProductsPage(driver);
    }
}
