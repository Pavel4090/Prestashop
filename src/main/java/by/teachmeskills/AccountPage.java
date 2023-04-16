package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    static final By ACCOUNT_TITLE = By.xpath("//h1[text()='My account']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(ACCOUNT_TITLE).isDisplayed();
    }
}
