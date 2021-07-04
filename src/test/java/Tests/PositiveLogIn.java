package Tests;

import LoginPage.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class PositiveLogIn extends LoginPage {

    @Test
    public void positiveTest() {
        super.getLoginButton();
        super.logInCredentials();
        super.getLoginButton().click();
        this.isUserLoggedInCheck();
    }

    public void isUserLoggedInCheck() {
        WebElement burgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenuButton.click();
        WebElement logOutButton = driver.findElement(By.id("logout_sidebar_link"));
        if (logOutButton.isDisplayed()){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}