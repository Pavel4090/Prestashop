package by.teachmeskills;

import by.teachmeskills.page.ItemPage;
import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkedAddingItemToCart() {
        ItemPage cartPage = new ProductsPage(driver).open()
                                                    .lookForHeader()
                                                    .changeLangToEn()
                                                    .goToLoginPage()
                                                    .loginWithValidData()
                                                    .goToProductsPage()
                                                    .addItemInCart();
        //.checkedItemInCart();
        Assertions.assertThat(cartPage)
                  .as("Item does not match")
                  .isNotNull();

    }
}
