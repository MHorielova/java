package tests;

import helpers.TestConfig;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;


public class PositiveLogIn extends TestConfig {

    @Test
    private void positiveTest() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        loginPage.logInCredentials();
        loginPage.loginButton.click();
        inventoryPage.isUserLoggedInCheck();
    }
}