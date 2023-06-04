package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutShippingPage extends BasePage{


    public CheckoutShippingPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPaymentPage agreeAndPickup() {
        WebElement agree = driver.findElement(By.xpath("//input[@type='checkbox']"));
        agree.click();
        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
        return new CheckoutPaymentPage(driver);
    }

    public CheckoutPaymentPage agreeAndDelivery() {
        WebElement agree = driver.findElement(By.xpath("//input[@type='checkbox']"));
        agree.click();
        driver.findElement(By.xpath("//div[@class='delivery_option alternate_item']//span")).click();
        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
        return new CheckoutPaymentPage(driver);
    }

}
