package tests;

import helpers.TestConfig;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeLogin extends TestConfig {

    LoginPage loginPage = new LoginPage(driver);

    @Test
    private void negativeTest() {
        loginPage.loginButton.click();
        loginPage.getError();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getError().getText(), "Epic sadface: Username is required", "Wrong error message");
        loginPage.getErrorButton();
        loginPage.getErrorButton().isDisplayed();
        loginPage.getError().isDisplayed();

        loginPage.logInCredentials();
        loginPage.loginButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "User not log in");
        softAssert.assertAll();
    }
}
