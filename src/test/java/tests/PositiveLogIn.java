package tests;

import helpers.PageWithBurgerMenu;
import helpers.TestConfig;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class PositiveLogIn extends TestConfig {

    private final LoginPage loginPage = new LoginPage(driver);//экземплар клаас или инстанс
    private final InventoryPage inventoryPage = new InventoryPage(driver);
    private final PageWithBurgerMenu burgerMenu = new PageWithBurgerMenu(driver);

    @Test
    public void positiveTest() {
        loginPage.logInByStandardUser();
        inventoryPage.isUserLoggedInCheck();
        burgerMenu.logOut();
    }
}