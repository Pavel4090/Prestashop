package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void checkedItemInfo() {
        driver.findElement(By.xpath("//span[@itemprop='price']")).isDisplayed();
        driver.findElement(By.xpath("//p[@id='product_reference']//span[@class='editable']")).isDisplayed();
        driver.findElement(By.xpath("//h1[@itemprop='name']")).isDisplayed();
        driver.findElement(By.id("image-block")).isDisplayed();

    }

//    public boolean checkedItemInCart() {
//        String avail = "In stock";
//        String name = "Blouse";
//        String price = "32,40 ₴";
//        boolean checked;
//        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
//        String availText = driver.findElement(By.xpath("//span[text()='In stock']")).getText();
//        String priceItem = driver.findElement(By.xpath("//td[@data-title='Total']//span[@class='price']")).getText();
//        String nameItem = driver.findElement(By.xpath("//p[@class='product-name']//a[text()='Blouse']")).getText();
//        if (availText.equals(avail)) {
//            checked = true;
//        } else {
//            checked = false;
//        }
//        if (checked) {
//            nameItem.equals(name);
//            checked = true;
//        } else {
//            checked = false;
//        }
//        if (checked) {
//            priceItem.equals(price);
//            checked = true;
//        } else checked = false;
//
//        return checked;
//    }
}
