package by.teachmeskills;

import by.teachmeskills.page.AccountPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginValidUser() {
        AccountPage accountPage = new ProductsPage(driver).open()
                                                          .getHeaderMenu()
                                                          .changeLangToEn()
                                                          .goToLoginPage()
                                                          .loginWithValidData();
        Assertions.assertThat(accountPage.isAccountPageOpened())
                  .isTrue()
                  .as("Account page should be opened after user logged with valid credentials");
    }

    @Test
    public void loginWithoutData() {
        String error = "An email address required.";
        LoginPage loginPage = new ProductsPage(driver).open()
                                                      .goToLoginPage()
                                                      .loginWithoutData();
        Assertions.assertThat(loginPage.errorMessage())
                  .isEqualTo(error)
                  .as("The error should be displayed");
    }

    @Test
    public void loginWithoutPassword() {
        String error = "Password is required.";
        LoginPage loginPage = new ProductsPage(driver).open()
                                                      .goToLoginPage()
                                                      .loginWithoutPassword();
        Assertions.assertThat(loginPage.errorMessage())
                  .isEqualTo(error)
                  .as("The error should be displayed");
    }

    @Test
    public void logoutTest() {
        boolean logout = new ProductsPage(driver).open()
                                                 .getHeaderMenu()
                                                 .changeLangToEn()
                                                 .goToLoginPage()
                                                 .loginWithValidData()
                                                 .getHeaderMenu()
                                                 .logout();
        Assertions.assertThat(logout)
                  .isTrue()
                  .as("User is not logout");
    }

    @Test
    public void loginWithWrongPassword() {
        String error = "Authentication failed.";
        LoginPage loginPage = new ProductsPage(driver).open()
                                                      .getHeaderMenu()
                                                      .changeLangToEn()
                                                      .goToLoginPage()
                                                      .loginWithWrongPassword();
        Assertions.assertThat(loginPage.errorMessage())
                  .as("The error should be displayed")
                  .isEqualTo(error);
    }

    @Test
    public void loginWithWrongEmail() {
        String error = "Invalid email address.";
        LoginPage loginPage = new ProductsPage(driver).open()
                                                      .getHeaderMenu()
                                                      .changeLangToEn()
                                                      .goToLoginPage()
                                                      .loginWithWrongEmail();
        Assertions.assertThat(loginPage.errorMessage())
                  .as("The error should be displayed")
                  .isEqualTo(error);
    }
}
