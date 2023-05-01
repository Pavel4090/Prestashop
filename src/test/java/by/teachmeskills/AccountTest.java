package by.teachmeskills;

import by.teachmeskills.page.AddressPage;
import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void addAddress() {
        AddressPage addressPage = new ProductsPage(driver).open()
                                                          .goToLoginPage()
                                                          .loginWithValidData()
                                                          .addNewAddressWithRequiredFields();
        Assertions.assertThat(addressPage.isAddressPageOpened())
                  .isTrue()
                  .as("New address should be added");
        Assertions.assertThat(addressPage.isAddressCreate())
                  .isTrue()
                  .as("New address is not created");

    }

    @Test
    public void deleteAddress() {
        boolean addressPage = new ProductsPage(driver).open()
                                                      .goToLoginPage()
                                                      .loginWithValidData()
                                                      .addNewAddressWithRequiredFields()
                                                      .isAddressCreated()
                                                      .deleteAddress()
                                                      .isAddressDeleted();
        Assertions.assertThat(addressPage)
                  .isTrue()
                  .as("Address should be deleted");

    }

    @Test
    public void checkedOrderHistory() {
        boolean accountPage = new ProductsPage(driver).open()
                                                      .getHeaderMenu()
                                                      .changeLangToEn()
                                                      .goToLoginPage()
                                                      .loginWithValidData()
                                                      .checkedOrderHistory();
        Assertions.assertThat(accountPage)
                  .isTrue()
                  .as("Order not checked");

    }
}
