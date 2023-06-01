package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkedItemInfo() {
        boolean itemText;
        String expText = "Printed Dress";
        driver.findElement(By.xpath("//span[@itemprop='price']")).isDisplayed();
        driver.findElement(By.xpath("//p[@id='product_reference']//span[@class='editable']")).isDisplayed();
        driver.findElement(By.xpath("//h1[@itemprop='name']")).isDisplayed();
        driver.findElement(By.id("image-block")).isDisplayed();
        String actualText = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
        itemText = actualText.equals(expText);
        return itemText;
    }

    public String getProductName() {
        return driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
    }
}
