package by.teachmeskills;

import by.teachmeskills.page.CheckoutPage;
import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void smokeTest() {
        final String productName = "Printed Dress";
        CheckoutPage checkoutPage = new ProductsPage(driver).open()
                                                            .getHeaderMenu()
                                                            .changeLangToEn()
                                                            .goToLoginPage()
                                                            .loginWithValidData()
                                                            .addNewAddressWithRequiredFields()
                                                            .goToProductsPage()
                                                            .addItemInCart(productName)
                                                            .checkProductName(productName)
                                                            .goToCheckout()
                                                            .nextCheckout()
                                                            .agreeAndNext()
                                                            .payBankWire()
                                                            .checkCurrency()
                                                            .checkingOrder();
        Assertions.assertThat(checkoutPage.checkedOrder())
                  .as("Order is not complete")
                  .isTrue();
        checkoutPage.goToAddressPage().deleteAddress();
    }
}
