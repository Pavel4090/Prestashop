package by.teachmeskills;

import by.teachmeskills.page.CartPage;
import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class NegativeTest extends BaseTest {

    @Test
    public void totalPriceTest() {
        final String itemName = "Printed Dress";
        CartPage cartPage = new ProductsPage(driver).open()
                                                    .getHeaderMenu()
                                                    .changeLangToEn()
                                                    .goToLoginPage()
                                                    .loginWithValidData()
                                                    .goToProductsPage()
                                                    .addItemInCart(itemName);
        String expectedPrice = cartPage.getTotalProducts();
        String actualPrice = cartPage.getTotalPrice();
        Assertions.assertThat(expectedPrice)
                  .isEqualTo(actualPrice)
                  .as("Total price calculated incorrectly");

    }
}
