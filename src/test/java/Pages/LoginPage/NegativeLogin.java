package Pages.LoginPage;

import Tests.BasicTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class NegativeLogin extends BasicTests {

    @Test
    public void negativeTest() {
        super.getLoginButton().click();
        super.getError1();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(super.getError1().getText(), "Epic sadface:Username is required", "Wrong error message");
        super.getErrorButton();
        super.getErrorButton().isDisplayed();

        super.logInCredentials();
        super.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "User not log in");
       }
}
