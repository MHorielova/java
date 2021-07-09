package pages;

import org.openqa.selenium.WebDriver;

public class InventoryPage {

    public WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void isUserLoggedInCheck() {
        if (driver.getCurrentUrl().contains("inventory")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
