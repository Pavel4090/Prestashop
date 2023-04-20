package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage nextCheckout() {
        driver.findElement(By.xpath("//button[@name='processAddress']")).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage agreeAndNext() {
        WebElement agree = driver.findElement(By.xpath("//input[@type='checkbox']"));
        agree.click();
        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage payBankWire() {
        driver.findElement(By.xpath("//a[@class='bankwire']")).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage payByCheck() {
        driver.findElement(By.xpath("//a[@class='cheque']")).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkCurrency() {
        boolean selected = driver.findElement(By.xpath("//option[@value='1']")).isSelected();
        if (!selected) {
            driver.findElement(By.xpath("//select[@id='currency_payement']")).click();
            driver.findElement(By.xpath("//option[@value='1']")).click();
        } else {
            driver.findElement(By.xpath("//span[text()='I confirm my order']")).click();
        }
        return new CheckoutPage(driver);
    }

    public boolean checkingOrder() {
        return driver.findElement(By.xpath("//h1[text()='Order confirmation']")).isDisplayed();
    }
}
