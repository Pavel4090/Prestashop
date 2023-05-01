package by.teachmeskills;

import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void emptySearch() {
        boolean productsPage = new ProductsPage(driver).open()
                                                       .searchNullItem();
        Assertions.assertThat(productsPage).isTrue().as("Search field is not empty");
    }

    @Test
    public void searchItem() {
        boolean item = new ProductsPage(driver).open()
                .searchItem()
                .checkedItemInfo();
        Assertions.assertThat(item).isTrue().as("Searching item does not match");
    }
}
