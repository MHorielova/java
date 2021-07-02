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
        WebElement error1 = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(error1.getText(), "Epic sadface:Username is required", "Wrong error message");
        WebElement errorButton = driver.findElement(By.xpath("//button[@class = 'error-button']"));
        errorButton.isDisplayed();
        String username = getFirstValue("login_credentials");
        String password = getFirstValue("login_password");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        super.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "User not log in");
       }
}
