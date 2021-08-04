package tests;

import helpers.PageWithBurgerMenu;
import helpers.TestConfig;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class PositiveLogIn extends TestConfig {

    // экземплар клаас или инстанс
    private final LoginPage loginPage = new LoginPage(driver);
    private final InventoryPage inventoryPage = new InventoryPage(driver);
    private final PageWithBurgerMenu burgerMenu = new PageWithBurgerMenu(driver);

    @Test
    public void positiveTest() {
        loginPage.logInByStandardUser();
        inventoryPage.isUserLoggedInCheck();
        burgerMenu.logOut();
    }
}