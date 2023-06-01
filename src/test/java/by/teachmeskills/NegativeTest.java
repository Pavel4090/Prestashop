package by.teachmeskills;

import by.teachmeskills.page.CartPage;
import by.teachmeskills.page.ProductsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class NegativeTest extends BaseTest {

    private final Logger log = LogManager.getLogger(BaseTest.class);

    @Test
    public void totalPriceTest() {
        final String itemName = "Printed Dress";
        log.info("What is the name of product: {}", itemName);
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
