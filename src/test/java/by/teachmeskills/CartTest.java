package by.teachmeskills;

import by.teachmeskills.page.OrderConfirmationPage;
import by.teachmeskills.page.ProductsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private final Logger log = LogManager.getLogger(BaseTest.class);

    @Test
    public void checkedAddingItemToCart() {
        final String itemName = "Dress";
        log.info("What is the name of item: {}", itemName);
        ProductsPage cartPage = new ProductsPage(driver).open()
                                                        .getHeaderMenu()
                                                        .changeLangToEn()
                                                        .goToLoginPage()
                                                        .loginWithValidData()
                                                        .goToProductsPage()
                                                        .addItemInTheCart(itemName);
        String expectedName = cartPage.goToItem(itemName).getProductName();
        String expectedPrice = cartPage.getProductPrice();
        String actualPrice = cartPage.goToCart().getItemPrice();
        String actualName = cartPage.getItemName();
        Assertions.assertThat(expectedName)
                  .isEqualTo(actualName)
                  .as("Product name does not match");
        Assertions.assertThat(expectedPrice)
                  .isEqualTo(actualPrice)
                  .as("Product price does not match");
    }

    @Test
    public void payByCheck() {
        final String productName = "Printed Dress";
        log.info("What is the name of product: {}", productName);
        final String expPayByCheck = "Your check must include:";
        OrderConfirmationPage cartPage = new ProductsPage(driver).open()
                                                                 .getHeaderMenu()
                                                                 .changeLangToEn()
                                                                 .getHeaderMenu()
                                                                 .signIn()
                                                                 .loginWithValidData()
                                                                 .addNewAddressWithRequiredFields()
                                                                 .goToProductsPage()
                                                                 .addItemInCart(productName)
                                                                 .goToCheckout()
                                                                 .nextCheckout()
                                                                 .agreeAndDelivery()
                                                                 .payByCheck()
                                                                 .checkCurrency()
                                                                 .checkingOrder();
        Assertions.assertThat(cartPage.getCheckText())
                  .as("User didn't pay by check")
                  .isEqualTo(expPayByCheck.toUpperCase());
        cartPage.goToAddressPage().deleteAddress();
    }

    @Test
    public void payByBankWire() {
        final String productName = "Printed Dress";
        log.info("What is the name of product: {}", productName);
        final String expPayByBankWire = "Please send us a bank wire with";
        OrderConfirmationPage cartPage = new ProductsPage(driver).open()
                                                                 .getHeaderMenu()
                                                                 .changeLangToEn()
                                                                 .getHeaderMenu()
                                                                 .signIn()
                                                                 .loginWithValidData()
                                                                 .addNewAddressWithRequiredFields()
                                                                 .goToProductsPage()
                                                                 .addItemInCart(productName)
                                                                 .goToCheckout()
                                                                 .nextCheckout()
                                                                 .agreeAndDelivery()
                                                                 .payByBankWire()
                                                                 .checkCurrency()
                                                                 .checkingOrder();
        Assertions.assertThat(cartPage.getBankWireText().substring(63, 94))
                  .as("User didn't pay by check")
                  .isEqualTo(expPayByBankWire);
        cartPage.goToAddressPage().deleteAddress();

    }
}
