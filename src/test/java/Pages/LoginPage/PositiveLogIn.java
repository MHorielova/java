package Pages.LoginPage;

import Tests.BasicTests;
import org.testng.annotations.Test;


public class PositiveLogIn extends BasicTests {

    @Test
    public void positiveTest() {
        super.getLoginButton();
        super.logInCredentials();
        super.getLoginButton().click();
        super.isUserLoggedInCheck();
    }

}