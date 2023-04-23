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
        AddressPage addressPage = new ProductsPage(driver).open()
                                                          .goToLoginPage()
                                                          .loginWithValidData()
                                                          .goToAddressPage()
                                                          .deleteAddress();
        Assertions.assertThat(addressPage.isAddressDeleted())
                  .isTrue()
                  .as("Address is not deleted");
    }

    @Test
    public void createAndDeleteAddress() {
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
}
