package Tests;

import LoginPage.LoginPage;
import org.testng.annotations.Test;

public class PositiveLogIn extends LoginPage {

    @Test
    public void positiveTest() {
        super.getLoginButton();
        super.logInCredentials();
        super.getLoginButton().click();
        super.isUserLoggedInCheck();
    }
}