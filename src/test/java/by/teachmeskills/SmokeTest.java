package by.teachmeskills;

import by.teachmeskills.page.OrderConfirmationPage;
import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void smokeTest() {
        final String productName = "Printed Dress";
        final String complete = "Your order on http://prestashop.qatestlab.com.ua/ is complete.";
        OrderConfirmationPage checkoutPage = new ProductsPage(driver).open()
                                                                     .getHeaderMenu()
                                                                     .changeLangToEn()
                                                                     .getHeaderMenu()
                                                                     .changeCurrency()
                                                                     .goToLoginPage()
                                                                     .loginWithValidData()
                                                                     .addNewAddressWithRequiredFields()
                                                                     .goToProductsPage()
                                                                     .addItemInCart(productName)
                                                                     .checkProductName(productName)
                                                                     .goToCheckout()
                                                                     .nextCheckout()
                                                                     .agreeAndPickup()
                                                                     .payByBankWire()
                                                                     .checkCurrency()
                                                                     .checkingOrder();
        Assertions.assertThat(checkoutPage.getTextComplete())
                  .isEqualTo(complete)
                  .as("Order is not complete");
        checkoutPage.goToAddressPage().deleteAddress();

    }
}
