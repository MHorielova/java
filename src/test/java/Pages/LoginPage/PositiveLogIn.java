package Pages.LoginPage;

import Tests.BasicTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class PositiveLogIn extends BasicTests {

    @Test
    public void positiveTest() {
        super.getLoginButton();
        String username = getFirstValue("login_credentials");
        String password = getFirstValue("login_password");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        super.getLoginButton().click();
        isUserLoggedInCheck();
    }

}