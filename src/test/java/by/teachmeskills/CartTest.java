package by.teachmeskills;

import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkedAddingItemToCart() {
        final String itemName = "Dress";
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
}
