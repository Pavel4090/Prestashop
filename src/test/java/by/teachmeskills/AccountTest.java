package by.teachmeskills;

import by.teachmeskills.page.AccountPage;
import by.teachmeskills.page.AddressPage;
import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void addAddress() {
        AddressPage addressPage = new ProductsPage(driver).open()
                                                          .getHeaderMenu()
                                                          .changeLangToEn()
                                                          .goToLoginPage()
                                                          .loginWithValidData()
                                                          .addNewAddressWithRequiredFields();
        Assertions.assertThat(addressPage.isAddressPageOpened())
                  .isTrue()
                  .as("New address should be added");
        Assertions.assertThat(addressPage.isAddressCreate())
                  .isTrue()
                  .as("New address is not created");
        boolean checkedAddress = addressPage.goToAccountPage().checkedAddress();
        Assertions.assertThat(checkedAddress)
                  .isTrue()
                  .as("Created address is correct");
        addressPage.deleteAddress();
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
        AccountPage accountPage = new ProductsPage(driver).open()
                                                          .getHeaderMenu()
                                                          .changeLangToEn()
                                                          .goToLoginPage()
                                                          .loginWithValidData();
        Assertions.assertThat(accountPage.checkedOrderHistory())
                  .isTrue()
                  .as("Order not checked");
    }
}
