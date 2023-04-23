package by.teachmeskills;

import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void smokeTest() {
        boolean checkoutPage = new ProductsPage(driver).open()
                                                       .lookForHeader()
                                                       .changeLangToEn()
                                                       .goToLoginPage()
                                                       .loginWithValidData()
                                                       .addNewAddressWithRequiredFields()
                                                       .goToProductsPage()
                                                       .addItemToCartAndGoToCart()
                                                       .checkProduct()
                                                       .goToCheckout()
                                                       .nextCheckout()
                                                       .agreeAndNext()
                                                       .payBankWire()
                                                       .checkCurrency()
                                                       .checkingOrder();
        Assertions.assertThat(checkoutPage).as("Order is not processed").isTrue();


    }
}
