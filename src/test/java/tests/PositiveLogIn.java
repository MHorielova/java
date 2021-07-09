package tests;

import helpers.TestConfig;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;


public class PositiveLogIn extends TestConfig {

    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);

    @Test
    private void positiveTest() {
        loginPage.logInCredentials();
        loginPage.loginButton.click();
        inventoryPage.isUserLoggedInCheck();
    }
}