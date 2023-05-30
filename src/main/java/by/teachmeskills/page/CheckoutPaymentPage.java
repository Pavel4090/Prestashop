package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPaymentPage extends BasePage{

    public CheckoutPaymentPage(WebDriver driver) {
        super(driver);
    }

    public OrderSummaryPage payByBankWire() {
        driver.findElement(By.xpath("//a[@class='bankwire']")).click();
        return new OrderSummaryPage(driver);
    }

    public OrderSummaryPage payByCheck() {
        driver.findElement(By.xpath("//a[@class='cheque']")).click();
        return new OrderSummaryPage(driver);
    }
}
