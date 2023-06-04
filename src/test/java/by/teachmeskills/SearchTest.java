package by.teachmeskills;

import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void emptySearch() {
        boolean productsPage = new ProductsPage(driver).open()
                                                       .searchNullItem();
        Assertions.assertThat(productsPage)
                  .isTrue()
                  .as("Search field is not empty");
    }

    @Test
    public void searchItemByFirstChr() {
        boolean item = new ProductsPage(driver).open()
                                               .searchItem()
                                               .checkedItemInfo();
        Assertions.assertThat(item)
                  .isTrue()
                  .as("Searching item does not match");
    }

    @Test
    public void searchItemByFullName() {
        String productName = "Printed Dress";
        boolean productsPage = new ProductsPage(driver).open()
                                                       .searchByFullName(productName)
                                                       .checkedItemInfo();
        Assertions.assertThat(productsPage)
                  .isTrue()
                  .as("Searching product does not match");
    }

    @Test
    public void wrongSearch() {
        String message = "123456";
        String productsPage = new ProductsPage(driver).open()
                                                      .wrongSearch(message)
                                                      .checkAlertMessage();
        String expMessage = "No results were found for your search " + "\"" + message + "\"";
        Assertions.assertThat(productsPage)
                  .isEqualTo(expMessage)
                  .as("Alert message is not displayed");
    }
}
