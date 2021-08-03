package pages;

import helpers.PageWithBurgerMenu;
import org.openqa.selenium.WebDriver;

public class InventoryPage  extends PageWithBurgerMenu {

    public InventoryPage(WebDriver driver) {
       super(driver);
    }

    public void isUserLoggedInCheck() {
        if (getCurrentUrl().contains("inventory")) System.out.println("true - user IS logged in");
        else {
            System.out.println("false - user is NOT logged in");
        }
    }
}
