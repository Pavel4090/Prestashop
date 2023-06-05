package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public OrderConfirmationPage checkingOrder() {
        driver.findElement(By.xpath("//h1[text()='Order confirmation']")).isDisplayed();
        return new OrderConfirmationPage(driver);
    }

    public String getTextComplete() {
        WebElement text = driver.findElement(By.xpath("//p//strong[@class='dark']"));
        return text.getText();
    }

    public AddressPage goToAddressPage() {
        driver.findElement(By.xpath("//li/a[@title='My addresses']")).click();
        return new AddressPage(driver);
    }

    public String getCheckText() {
        WebElement payByCheck = driver.findElement(By.xpath("//h3[@class='page-subheading']"));
        return payByCheck.getText();
    }

    public String getBankWireText() {
        WebElement payByBank = driver.findElement(By.xpath("//div[@class='box']"));
        return payByBank.getText();
    }
}
