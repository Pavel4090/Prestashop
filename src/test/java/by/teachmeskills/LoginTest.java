package by.teachmeskills;

import by.teachmeskills.page.AccountPage;
import by.teachmeskills.page.ProductsPage;
import by.teachmeskills.page.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void checkLoginForValidUser() {
        AccountPage accountPage = new ProductsPage(driver).open()
                                                          .lookForHeader()
                                                          .changeLang()
                                                          .goToLoginPage()
                                                          .loginWithValidData();
        Assertions.assertThat(accountPage.isAccountPageOpened())
                .isTrue()
                .as("Account page should be opened after user logged with valid credentials");
    }

    @Test
    public void loginWithoutData() {
        LoginPage loginPage = new ProductsPage(driver).open()
                                                      .goToLoginPage()
                                                      .loginWithoutData();
        Assertions.assertThat(loginPage.errorMessageOfEmail()).isTrue().as("The error should be displayed");
    }

    @Test
    public void loginWithoutPassword() {
        LoginPage loginPage = new ProductsPage(driver).open()
                                                      .goToLoginPage()
                                                      .loginWithoutPassword();
        Assertions.assertThat(loginPage.errorMessageOfPassword()).isTrue().as("The error should be displayed");
    }
}
