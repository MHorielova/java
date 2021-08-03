package tests;

import helpers.PageWithBurgerMenu;
import helpers.TestConfig;
import pages.InventoryPage;
import pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeLogin extends TestConfig {

    private final LoginPage loginPage = new LoginPage(driver);
    private final InventoryPage inventoryPage = new InventoryPage(driver);
    private final PageWithBurgerMenu burgerMenu = new PageWithBurgerMenu(driver);

    @Test
    private void negativeTest() {
        loginPage.loginButton.click();
        loginPage.getError().isDisplayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getError().getText(), "Epic sadface: Username is required", "Wrong error message");
        loginPage.getErrorButton().isDisplayed();
        loginPage.logInByStandardUser();
        //Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "User not log in");
        //softAssert.assertAll();
        inventoryPage.isUserLoggedInCheck();
        burgerMenu.logOut();
    }
}
