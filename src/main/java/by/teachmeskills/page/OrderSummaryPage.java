package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage extends BasePage{

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    public OrderConfirmationPage checkCurrency() {
        boolean selected = driver.findElement(By.xpath("//option[@value='1']")).isSelected();
        if (!selected) {
            driver.findElement(By.xpath("//select[@id='currency_payement']")).click();
            driver.findElement(By.xpath("//option[@value='1']")).click();
            driver.findElement(By.xpath("//span[text()='I confirm my order']")).click();
        } else {
            driver.findElement(By.xpath("//span[text()='I confirm my order']")).click();
        }
        return new OrderConfirmationPage(driver);
    }
}
