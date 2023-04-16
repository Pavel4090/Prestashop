package by.teachmeskills;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void addAddress() {
        AccountPage accountPage = new HomePage(driver).openSite()
                                                      .goToLoginPage()
                                                      .loginWithValidData()
                                                      .addNewAddressWithRequiredFields();
        Assertions.assertThat(accountPage.isAddressPageOpened())
                                         .isTrue()
                                         .as("New address should be added");

    }
}
